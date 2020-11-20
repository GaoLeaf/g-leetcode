package cn.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * <B>删除排序数组中的重复项</B>
 * <p>给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。</p>
 * <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。</p>
 *
 * @author gaowenjin
 * @date 2020/11/19
 * @description:
 */
public class RemoveDuplicatesFromSortedArray_26 {

    @Test
    public void test() {

        int[] arrs = {1, 1, 2};

        System.out.println(RemoveDuplicatesFromSortedArray_26.removeDuplicates(arrs));

    }

    /**
     * 双指针法
     * 时间复杂度：O(n),假设数组长度是n，那么i最多走n步。
     * 空间复杂度：O(1)
     */
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        System.out.println(Arrays.toString(nums));

        return i + 1;

    }

}
