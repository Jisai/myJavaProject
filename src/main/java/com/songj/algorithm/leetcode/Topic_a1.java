package com.songj.algorithm.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * 给一个单词s,和一个字符串集合str。这个单词每次去掉一个字母，直到剩下最后一个字母。
 * 求验证是否存在一种删除的顺序，这个顺序下所有的单词都在str中。
 * 例如单词是’abc’，字符串集合是{‘a’,’ab’,’abc’},
 * 如果删除的顺序是’c’,’b’，那么’abc’,’ab’,’a’都在集合中,
 * 就符合条件。输出这个组合是否符合条件.
 *
 * 1<=|str[i]|,|s|<=30
 * 1<=str中字符串的个数<=100
 *
 * 样例 1:
 * 输入：s="abc"，str=["abc","ac","c"]
 * 输出：true 解释：
 * 首先"abc"在`str`里
 * 删除'b',"ac"在`str`里
 * 删除'a',"c"在`str`里

 * 样例 2:
 * 输入：s="abc",str=["abc","ab","c"]
 * 输出：false 解释： "abc"在`str`里
 * 接下来只能删除'c',"ab"在`str`里
 * 由于"a"和"b"都不在`str`里，所以返回false
 *
 * 【题解】 考点：
 * 按照题目要求，首先保证原串存在于str中。
 * 每次拼接字符串，正好删去一个字符继续搜索。
 * 直至当前字符串长度为1返回为true。
 * 使用TreeSet标记，除去重复字符串。
 **/
public class Topic_a1 {

    /**
     * @param s:
     * @param str:
     * @return: Output whether this combination meets the condition
     */
    Set<String> map = new TreeSet<String>();

    public boolean checkWord(String s, String[] str) { // Write your code here
        if (s.length() > str.length) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return dfs(s, str);
    }

    public boolean dfs(String s, String[] str) {
        int result = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(s)) {
                result = 1;
            }
        }
        if (result == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        } //当前的子串要没被访问过的
        if (map.contains(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) { //删除一个字母后的下一个子串
            String next = s.substring(0, i) + s.substring(i + 1);
            if (dfs(next, str)) {
                return true;
            }
        } //新的子串放入map，为之后子串检查访问情况
        map.add(s);
        return false;
    }

}
