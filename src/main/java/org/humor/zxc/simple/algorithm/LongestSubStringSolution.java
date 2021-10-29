package org.humor.zxc.simple.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2021/9/23
 * Time: 2:04 下午
 *
 * @author xuzz
 */
public class LongestSubStringSolution {


    /**
     * 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。
     */
    public static int longestSubStringLength(String s) {

        Set<Character> charSet = new HashSet<>(s.length());
        int res = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (charSet.contains(c)) {
                System.out.println(charSet);
                charSet.remove(s.charAt(start));
                start++;
                System.out.println(charSet);
            }

            res = Math.max(res, i - start + 1);
            charSet.add(s.charAt(i));
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }

        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        longestSubStringLength("eadfdba");
    }

}
