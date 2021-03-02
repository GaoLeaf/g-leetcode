package cn.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * <B>区域和检索 - 数组不可变</B>
 *
 * <p>给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。</p>
 * <p>实现 NumArray 类：</p>
 * <p>NumArray(int[] nums) 使用数组 nums 初始化对象</p>
 * <p>int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）</p>
 *
 * @author gaowenjin
 * @date 2021/3/2
 * @description:
 */
public class RangeSumQueryImmutable_303 {

    @Test
    public void test() {

        int[] sum1 = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(sum1);

        Assert.assertEquals(1, numArray.sumRange(0, 2));
        Assert.assertEquals(-1, numArray.sumRange(2, 5));
        Assert.assertEquals(-3, numArray.sumRange(0, 5));

    }

    class NumArray {
        // 存放数组的值：将数组前缀的和依次相加，并放入
        int[] totalSums;

        public NumArray(int[] nums) {

            int len = nums.length;
            totalSums = new int[len + 1];

            for (int i = 0; i < len; i++) {
                totalSums[i + 1] = totalSums[i] + nums[i];
            }

        }

        // 计算区间的值
        public int sumRange(int i, int j) {
            return totalSums[j + 1] - totalSums[i];
        }
    }

}
