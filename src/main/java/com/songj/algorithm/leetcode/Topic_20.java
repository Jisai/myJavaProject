package com.songj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassNamee: Topic_20 有效的括号
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 * @Author: Scott S
 * @Date: 2022-02-06 21:07
 * @Version: 1.0
 **/
public class Topic_20 {



    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return  false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(stack.empty() || !stack.peek().equals(map.get(s.charAt(i))) ){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.empty()){return true;}
        return false;
    }

}
