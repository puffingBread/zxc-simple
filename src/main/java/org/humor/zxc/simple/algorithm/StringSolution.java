package org.humor.zxc.simple.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2021/9/26
 * Time: 4:42 下午
 *
 * @author xuzz
 */
public class StringSolution {


    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * 如输入: pattern = "abba", str = "dog cat cat dog" 输出: true
     * 输入:pattern = "abba", str = "dog cat cat fish" 输出: false
     */
    public static boolean wordPattern(String pattern, String s) {

        String[] subArray = s.split(" ");
        if (pattern.length() != subArray.length) {
            return false;
        }
        Map<Character, String> charMap = new HashMap<>(pattern.length());

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = subArray[i];
            if (charMap.containsKey(key)) {
                if (!value.equals(charMap.get(key))) {
                    return false;
                }
            } else {
                if (charMap.containsValue(value)) {
                    return false;
                }
                charMap.put(key, value);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s1 = "dog cat cat dog";
        String s2 = "dog cat cat fish";
        System.out.println("s1 match = " + wordPattern(pattern, s1));
        System.out.println("s2 match = " + wordPattern(pattern, s2));
    }

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * <p>
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * <p>
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;

        //左右指针为中心点，i在0～2n-2之间都不会越界
        for (int i = 0; i < 2 * len - 1; i++) {

            int l = i / 2, r = i / 2 + i % 2;

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                res++;
            }
        }

        return res;
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */
    public String longestPalindrome(String s) {
//        boolean b;
//        short sh;
//        int i;
//        long l;
//        double d;
//        float f;
//        char c;
//        byte by;
        return "";
    }
}
