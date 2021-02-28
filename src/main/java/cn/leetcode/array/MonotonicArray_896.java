package cn.leetcode.array;

import org.junit.Test;

/**
 * <B>单调数列</B>
 *
 * <p>如果数组是单调递增或单调递减的，那么它是单调的。</p>
 * <p>如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。</p>
 * <p>当给定的数组 A 是单调数组时返回 true，否则返回 false。</p>
 *
 * @author gaowenjin
 * @date 2021/2/28
 * @description:
 */
public class MonotonicArray_896 {

    @Test
    public void test() {

        int[] A1 = {1, 2, 2, 3};
        System.out.println("A1" + isMonotonic(A1));
        System.out.println("A1:" + (isMonotonicV2(A1, true) || isMonotonicV2(A1, false)));

        int[] A2 = {6, 5, 4, 4};
        System.out.println("A2" + isMonotonic(A2));
        System.out.println("A2:" + (isMonotonicV2(A2, true) || isMonotonicV2(A2, false)));

        int[] A3 = {1, 3, 2};
        System.out.println("A3" + isMonotonic(A3));
        System.out.println("A3:" + (isMonotonicV2(A3, true) || isMonotonicV2(A3, false)));

        int[] A4 = {1, 2, 4, 5};
        System.out.println("A4" + isMonotonic(A4));
        System.out.println("A4:" + (isMonotonicV2(A4, true) || isMonotonicV2(A4, false)));

        int[] A5 = {1, 1, 1};
        System.out.println("A5:" + isMonotonic(A5));
        System.out.println("A5:" + (isMonotonicV2(A5, true) || isMonotonicV2(A5, false)));

    }

    // 一次遍历
    public boolean isMonotonic(int[] A) {

        boolean inc = true; // 升序
        boolean desc = true; // 降序
        int size = A.length;
        for (int i = 0; i < size - 1; i++) {

            if (A[i] > A[i + 1]) {
                inc = false;
            }

            if (A[i] < A[i + 1]) {
                desc = false;
            }

            if (!inc && !desc) {
                return false;
            }

        }

        return inc || desc;

    }

    // 二次遍历
    public boolean isMonotonicV2(int[] A, boolean increasing) {

        int size = A.length;

        if (increasing) {
            for (int i = 0; i < size - 1; i++) {

                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }

        return true;

    }

}
