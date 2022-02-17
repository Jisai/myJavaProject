package com.songj.util;

import cn.hutool.json.JSONUtil;
import com.github.binarywang.java.emoji.EmojiConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: EmojiUtil
 * @BelongPackage: com.songj.util
 * @Description: 表情包工具类
 * https://blog.csdn.net/weixin_44698541/article/details/108801804
 * https://blog.csdn.net/huangdingsheng/article/details/90176502
 * @Author: Jisai
 * @Date: 2021/3/3 下午7:07
 * @Version: v1.0
 */
public class EmojiUtil {
    private static Logger logger = Logger.getLogger(EmojiUtil.class);
    private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

    /**
     * 判断是否存在Emoji
     * @author madaha
     *
     * @param codePoint
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9)
                || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     * @author madaha
     *
     * @param source 待过滤字符串
     * @return
     */
    public static String filterEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }
        if (buf == null) {
            return source;
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    /**
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     * @param str 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiConvert1(String str) throws UnsupportedEncodingException {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb, "[[" + URLEncoder.encode(matcher.group(1), "UTF-8") + "]]");
            } catch (UnsupportedEncodingException e) {
                logger.error("转义失败 emojiConverterUnicodeStr# param = "+str+", E = " + JSONUtil.toJsonStr(e));
                System.out.println(e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        // System.out.println("emojiConvert " + str + " to " + sb.toString() + ", len：" + sb.length());
        return sb.toString();
    }

    /**
     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
     * @param str 转换前的字符串
     * @return 转换后的字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiRecovery2(String str) throws UnsupportedEncodingException {
        String patternString = "\\[\\[(.*?)\\]\\]";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb, URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error("转义失败 emojiRecovery2# param = "+str+", E = " + JSONUtil.toJsonStr(e));
                System.out.println(e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        // System.out.println("emojiRecovery " + str + " to " + sb.toString());
        return sb.toString();
    }



    /**
     * 将emojiStr转为 带有表情的字符
     * @param emojiStr
     * @return
     */
    public static String emojiConverterUnicodeStr(String emojiStr){
        if(StringUtils.isBlank(emojiStr)){
            return emojiStr;
        }
        String result = emojiConverter.toUnicode(emojiStr);
        return result;
    }

    /**
     * 带有表情的字符串转换为编码
     * @param str
     * @return
     */
    public static String emojiConverterToAlias(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }
        String result=emojiConverter.toAlias(str);
        return result;
    }




}
