package cn.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * <B>翻转图像</B>
 *
 * <p>给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。</p>
 * <p>水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。</p>
 * <p>反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。</p>
 *
 * @author gaowenjin
 * @date 2021/2/24
 * @description:
 */
public class FlippingAnImage_832 {

    @Test
    public void test() {

        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        print(flipAndInvertImage(A));

        int[][] A1 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(A1));

    }

    /**
     * 暴力翻转 <br/>
     * 一维数组循环，二维数组拆分成2部分，翻转后替换数值
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int[] a1 = A[i];
            int len = a1.length - 1;
            for (int j = 0; j <= len / 2; j++) {

                int h = A[i][j];
                int t = A[i][len - j];

                A[i][j] = 1 - t;
                A[i][len - j] = 1 - h;
            }
        }

        return A;
    }

    public void print(int[][] ints) {
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }

}
