package com.songj.otherAbout;

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




}
