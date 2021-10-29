package org.humor.zxc.simple.algorithm;

/**
 * Date: 2021/10/9
 * Time: 3:50 下午
 *
 * @author xuzz
 */
public class MaxAreaSolution {

    public static int maxArea(int[] height) {

        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }
}
