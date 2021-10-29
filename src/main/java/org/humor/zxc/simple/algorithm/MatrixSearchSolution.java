package org.humor.zxc.simple.algorithm;

/**
 * Date: 2021/10/12
 * Time: 11:02 上午
 *
 * @author xuzz
 */
public class MatrixSearchSolution {

    /**
     * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 出发点选左下或右上才是最优解
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {

            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}
