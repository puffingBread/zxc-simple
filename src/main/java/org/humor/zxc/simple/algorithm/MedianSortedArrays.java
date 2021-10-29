package org.humor.zxc.simple.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2021/9/29
 * Time: 5:59 下午
 *
 * @author xuzz
 */
public class MedianSortedArrays {


    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new LinkedList<>();
        if (nums1.length > 0) {
            Arrays.stream(nums1).forEach(list::add);
        }
        if (nums2.length > 0) {
            Arrays.stream(nums2).forEach(list::add);
        }

        int size = list.size();
        if (size == 0) {
            return 0d;
        }

        if (size == 1) {
            return list.get(0);
        }

        Collections.sort(list);
        if (size % 2 == 0) {

            return (list.get(size / 2 - 1).doubleValue() + list.get(size / 2).doubleValue()) / 2;
        }

        return list.get(size / 2);
    }

    public static void main(String[] args) {
        int[] n1 = {2};
        int[] n2 = {1, 3};

        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
