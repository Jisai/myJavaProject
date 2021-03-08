package com.songj.otherAbout;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.songj.util.EmojiUtil;
import com.vdurmont.emoji.EmojiParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: TestOneMain
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-06-06 17:18
 * @Version: 1.0
 */
public class TestOneMain {

    @Test
    public void test01(){
        System.out.println(7099+7099+6399+6399+7099+7099+6399+7099+6399);
    }

    @Test
    public void testSwitch(){
        String result = "";
        Integer code = null;
        switch (code){
//        case null: result = "null";
            case 1:
                result = "1";
                break;
            case 2: result = "2";
                break;
            default:  result = "null";
        }
        System.out.println(result);
    }

    /**
     * emoji表情处理测试方法
     */
    @Test
    public void emojiTest(){
        //  第一种方式
        System.out.println(">>>  第一种方式");
        String str_1 = "emoji表情😁😁输入测试😁😂";
        System.out.println("原始字符为： " + str_1);
        System.out.println("to aliases 之后： " + EmojiParser.parseToAliases(str_1));

        str_1 = EmojiParser.parseToAliases(str_1);
        System.out.println("还原： " + EmojiParser.parseToUnicode(str_1));

        //  第二种方式
        System.out.println(">>>  第二种方式");
        String str_2 = "emoji表情😁😁输入测试😁😂";
        System.out.println("原始字符为： " + str_2);
        System.out.println("to aliases 之后： " + EmojiUtil.emojiConverterToAlias(str_2));

        str_2 = EmojiUtil.emojiConverterToAlias(str_2);
        System.out.println("还原： " + EmojiUtil.emojiConverterUnicodeStr(str_2));
    }

    private EmojiConverter emojiConverter = EmojiConverter.getInstance();

    @Test

    public void testToAlias() {
        String str = "  An 😃😀awesome 😃😃string with a few 😃😉emojis!";

        String alias = this.emojiConverter.toAlias(str);

        System.out.println(str);

        System.out.println("EmojiConverterTest.testToAlias()=====>");

        System.out.println(alias);

        Assert.assertEquals(

                ":no_good: :ok_woman: :couple_with_heart:An :smiley::grinning:awesome :smiley::smiley:string with a few :smiley::wink:emojis!",

                alias);

    }

    @Test

    public void testToHtml() {
        String str = "  An 😀😃awesome 😃😃string with a few 😉😃emojis!";

        String result = this.emojiConverter.toHtml(str);

        System.out.println(str);

        System.out.println("EmojiConverterTest.testToHtml()=====>");

        System.out.println(result);

        Assert.assertEquals(

                "🙅 🙆 💑An 😀😃awesome 😃😃string with a few 😉😃emojis!",

                result);

    }

    @Test

    public void testToUnicode() {
        String str = "   :smiley: :grinning: :wink:";

        String result = this.emojiConverter.toUnicode(str);

        System.err.println(str);

        System.err.println("EmojiConverterTest.testToUnicode()=====>");

        System.err.println(result);

        Assert.assertEquals("🙅 🙆 💑 😃 😀 😉", result);

    }




}
