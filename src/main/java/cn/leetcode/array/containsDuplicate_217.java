package cn.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <B>存在重复元素</B>
 * <p>给定一个整数数组，判断是否存在重复元素。</p>
 * <p>如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。</p>
 *
 * @author gaowenjin
 * @date 2020/12/13
 * @description:
 */
public class containsDuplicate_217 {

    @Test
    public void test() {

        int[] l = new int[]{1, 2, 3, 3};
        int[] l1 = new int[]{1, 2, 3};
        System.out.println(containsDuplicate(l));
        System.out.println(containsDuplicate(l1));
        System.out.println(containsDuplicateBySort(l));
        System.out.println(containsDuplicateBySort(l1));

    }

    /**
     * 将数组排序后判断是否重复
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateBySort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 通过哈希判断
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
