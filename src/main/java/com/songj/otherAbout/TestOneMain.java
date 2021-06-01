package com.songj.otherAbout;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.songj.util.EmojiUtil;
import com.songj.util.EmojiUtil2;
import com.vdurmont.emoji.EmojiParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void emojiTest() throws Exception{
        String str = "😜 🤪 🤨 emoji😸🛩🚆表情😁😁输入🙅 🙆 💑An 😀😃测试😁😂\uD83C\uDDF9 \uD83C\uDDF7 \uD83C\uDDF0 \uD83C\uDDEB";

        //  第一种方式 [部分表情不支持转义]
//        System.out.println(">>>  第一种方式");
//
//        System.out.println("原始字符为： " + str);
//        System.out.println("to aliases 之后： " + EmojiParser.parseToAliases(str));
//
//        str = EmojiParser.parseToAliases(str);
//        System.out.println("还原： " + EmojiParser.parseToUnicode(str));

        //  第二种方式
        System.out.println(">>>  第二种方式");
        System.out.println("原始字符为： " + str);
        System.out.println("to aliases 之后： " + EmojiUtil.emojiConvert1(str));

        str = EmojiUtil.emojiConvert1(str);
        System.out.println("还原： " + EmojiUtil.emojiRecovery2(str));

        //  第三种方式 [可能存在新表情转义报错]
//        System.out.println(">>>  第三种方式");
//        System.out.println("原始字符为： " + str);
//        System.out.println("to aliases 之后： " + EmojiUtil.emojiConverterToAlias(str));
//
//        str = EmojiUtil.emojiConverterToAlias(str);
//        System.out.println("还原： " + EmojiUtil.emojiConverterUnicodeStr(str));

        //  第四种方式
        System.out.println(">>>  第四种方式");
        System.out.println("原始字符为： " + str);
        System.out.println("to aliases 之后： " + EmojiUtil2.encodeEmoji2(str));

        str = EmojiUtil2.encodeEmoji2(str);
        System.out.println("还原： " + EmojiUtil2.translationEmoji2(str));
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

    @Test
    public void testTry(){
        int a =1;
        System.out.println(tryPri(a));
    }
    private int tryPri(int a){
        try {
            a = a+1;
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            a = a + 10;
            return a;

        }
    }

    @Test
    public void testFor(){
        for(int i = 0; i < 4; i++){
            System.out.println("i=" + i);
            for(int j = 0; j < 4; j++){
                System.out.println("j=" + j);
                break;
            }
        }
    }


    @Test
    public void test05(){

    }




}
