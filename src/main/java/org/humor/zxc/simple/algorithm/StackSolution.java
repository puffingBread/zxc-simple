package org.humor.zxc.simple.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * TODO ADD DESCRIPTION
 *  Date: 2021/10/14
 *  Time: 10:21 上午
 *  @author xuzz
 */
public class StackSolution {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public boolean isValid(String s) {

        int length = s.length();
        //长度为奇数直接返回
        if (length % 2 == 1) {
            return false;
        }

        //应先把左括号放入辅助栈中，再判断右括号出现时栈中左括号
        Map<Character, Character> charMap = new HashMap<>(3);
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');

        LinkedList<Character> linkedList = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                if (linkedList.size() == 0 || !Objects.equals(linkedList.peek(), charMap.get(c))) {
                    return false;
                }
                linkedList.pop();
            } else {
                linkedList.push(c);
            }
        }
        return linkedList.size() == 0;
    }
}
