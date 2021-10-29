package org.humor.zxc.simple.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 求和
 * Date: 2021/9/29
 * Time: 11:26 上午
 *
 * @author xuzz
 */
public class SumSolution {

    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * 示例1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * <p>
     * 示例2：
     * 输入：nums = []
     * 输出：[]
     * <p>
     * 示例3：
     * 输入：nums = [0]
     * 输出：[]
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resList = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //已排序，若出现大于0的元素，则往后不可能出现和为0的三数解
            if (nums[i] > 0) {
                break;
            }

            //出现重复数字时跳过，避免重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //左指针大于i，保证i与指针不出现重合
            int left = i + 1;
            int right = nums.length - 1;

            //左指针小于右指针，保证不出现重合
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //三数之和小于0，则左指针右移；大于0，则右指针左移
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> sumList = new ArrayList<>(3);
                    sumList.add(nums[i]);
                    sumList.add(nums[left]);
                    sumList.add(nums[right]);
                    resList.add(sumList);

                    //双指针内部去重, left < right 防止越界
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }

        }

        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }
}
