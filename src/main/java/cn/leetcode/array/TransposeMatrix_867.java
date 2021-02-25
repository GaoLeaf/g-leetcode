package cn.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * <B>转置矩阵</B>
 *
 * <p>给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。</p>
 * <p>矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。</p>
 *
 * @author gaowenjin
 * @date 2021/2/25
 * @description:
 */
public class TransposeMatrix_867 {

    @Test
    public void test() {

        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(transpose(A));

        System.out.println("=====================================分割线=====================================");

        int[][] A1 = {{1, 2, 3}, {4, 5, 6}};
        print(transpose(A1));

    }

    public int[][] transpose(int[][] matrix) {

        // 计算二维数组内外层长度
        int out_len = matrix.length, in_len = matrix[0].length;
        // 初始化处理后的二维数组
        int[][] dispose_matrix = new int[in_len][out_len];
        for (int i = 0; i < out_len; i++) {

            for (int j = 0; j < in_len; j++) {
                // 对称替换值
                dispose_matrix[j][i] = matrix[i][j];
            }

        }

        return dispose_matrix;

    }

    public void print(int[][] ints) {
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }

}
