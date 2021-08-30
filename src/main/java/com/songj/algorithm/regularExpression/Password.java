package com.songj.algorithm.regularExpression;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @ClassNamee: Password
 * @Description: 密码相关 正则表达式
 * @Author: Scott S
 * @Date: 2020-03-06 10:22
 * @Version: 1.0
 **/
public class Password {


    @Test
    public void checkPassword01(){
        String password1 = " 12345 6789 ";
        System.out.println(password1.length());
        System.out.println("replace>>" + password1.replace(" ", ""));
        System.out.println("replaceAll>>" + password1.replaceAll(" ", ""));
        System.out.println(password1.replace(" ", "").length());
        System.out.println(password1.length());
        boolean passwordLength = PwdCheckUtil.checkPasswordLength(password1,"8","18");
        boolean containDigit = PwdCheckUtil.checkContainDigit(password1);
        boolean containCase = PwdCheckUtil.checkContainCase(password1);
        System.out.println(">>> " + passwordLength + ">>> " +  containDigit + ">>> " +  containCase);
    }



}
