package com.songj.util;

import com.songj.annotation.Emoji;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;


public class EmojiUtil2 {
    private static final Logger logger = LoggerFactory.getLogger(EmojiUtil.class);

    private static BitSet dontNeedEncoding;

    static {
        dontNeedEncoding = new BitSet(256);
        int i;
        for (i = 'a'; i <= 'z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = 'A'; i <= 'Z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = '0'; i <= '9'; i++) {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set('+');
        dontNeedEncoding.set('-');
        dontNeedEncoding.set('_');
        dontNeedEncoding.set('.');
        dontNeedEncoding.set('*');
    }

    /**
     * 检测是否有emoji字符
     *
     * @param source
     * @return 一旦含有就抛出
     */
    public static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isNotEmojiCharacter(codePoint)) {
                //判断到了这里表明，确认有表情字符
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为非Emoji字符
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isNotEmojiCharacter(char codePoint) {
        return codePoint == 0x0 || codePoint == 0x9 || codePoint == 0xA || codePoint == 0xD || codePoint >= 0x20 && codePoint <= 0xD7FF || codePoint >= 0xE000 && codePoint <= 0xFFFD;
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        if (!containsEmoji(source)) {
            return source;
        }
        StringBuilder buf = new StringBuilder();
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint)) {
                buf.append(codePoint);
            }
        }

        return buf.toString().trim();
    }

    /**
     * 判断str是否urlEncoder.encode过
     *
     * @param str
     * @return
     */
    public static boolean hasUrlEncoded(String str) {

        /**
         * 支持JAVA的URLEncoder.encode出来的string做判断。 即: 将' '转成'+' <br>
         * 0-9a-zA-Z保留 <br>
         * '-'，'_'，'.'，'*'保留 <br>
         * 其他字符转成%XX的格式，X是16进制的大写字符，范围是[0-9A-F]
         */
        boolean needEncode = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (dontNeedEncoding.get((int) c)) {
                continue;
            }
            if (c == '%' && (i + 2) < str.length()) {
                // 判断是否符合urlEncode规范
                char c1 = str.charAt(++i);
                char c2 = str.charAt(++i);
                if (isDigit16Char(c1) && isDigit16Char(c2)) {
                    continue;
                }
            }
            // 其他字符，肯定需要urlEncode
            needEncode = true;
            break;
        }

        return !needEncode;
    }

    /**
     * 判断c是否是16进制的字符
     *
     * @param c
     * @return
     */
    private static boolean isDigit16Char(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F');
    }

    /**
     * 将包含emoji的字符串进行编码
     */
    public static String encodeEmoji2(String containEmojiString) {
        // 判断当前字符串是否包含emoji
        if (!containsEmoji(containEmojiString)) {
            return containEmojiString;
        }
        String compileEmojiString = null;
        try {
            compileEmojiString = URLEncoder.encode(containEmojiString, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return compileEmojiString;
    }
    /**
     * 将包含emoji的字符串进行解码
     *
     */
    public static String translationEmoji2(String containEmojiString) {

        if (StringUtils.isBlank(containEmojiString)) {
            return containEmojiString;
        }

        if (!hasUrlEncoded(containEmojiString)) {
            return containEmojiString;
        }

        String compileEmojiString = null;
        try {
            compileEmojiString = URLDecoder.decode(containEmojiString, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return compileEmojiString;
    }

    /**
     * 将包含emoji的字符串进行编码
     *
     * @param t
     * @param <T>
     */
    public static <T> void encodeEmoji(T t) {
        if (t == null) {
            return;
        }

        List<Field> fieldList = Arrays.stream(t.getClass().getDeclaredFields()).filter(x -> x.getAnnotation(Emoji.class) != null).collect(Collectors.toList());

        try {
            for (Field field : fieldList) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), t.getClass());

                Method getMethod = pd.getReadMethod();
                Object object = getMethod.invoke(t);
                String containEmojiString = object == null ? "" : object.toString();

                if (StringUtils.isBlank(containEmojiString)) {
                    return;
                }

                // 判断当前字符串是否包含emoji
                if (!containsEmoji(containEmojiString)) {
                    return;
                }

                String compileEmojiString = URLEncoder.encode(containEmojiString, "utf-8");

                Method setMethod = pd.getWriteMethod();
                setMethod.invoke(t, compileEmojiString);
            }
        } catch (Exception e) {
            logger.error("Convert emoji string to encode failed.");
        }
    }

    /**
     * 将包含emoji的字符串进行解码
     *
     * @param t
     * @param <T>
     */
    public static <T> void translationEmoji(T t) {
        if (t == null) {
            return;
        }

        List<Field> fieldList = Arrays.stream(t.getClass().getDeclaredFields()).filter(x -> x.getAnnotation(Emoji.class) != null).collect(Collectors.toList());
        try {
            for (Field field : fieldList) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), t.getClass());

                Method getMethod = pd.getReadMethod();
                Object object = getMethod.invoke(t);
                String containEmojiString = object == null ? "" : object.toString();

                if (StringUtils.isBlank(containEmojiString)) {
                    return;
                }

                if (!hasUrlEncoded(containEmojiString)) {
                    return;
                }

                String compileEmojiString = URLDecoder.decode(containEmojiString, "utf-8");

                Method setMethod = pd.getWriteMethod();
                setMethod.invoke(t, compileEmojiString);
            }
        } catch (Exception e) {
            logger.error("Convert emoji string to decode failed.");
        }
    }
}



