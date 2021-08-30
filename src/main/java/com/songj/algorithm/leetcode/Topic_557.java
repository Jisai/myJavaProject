package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_557   https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @Description: 反转字符串中的单词 III
 * @Author: Scott S
 * @Date: 2021-07-17 09:07
 * @Version: 1.0
 **/
public class Topic_557 {

    /**使用额外空间
     * 开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，
     * 此时找到了一个单词，并能得到单词的起止位置。
     * 随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。
     * 如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
     */
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
