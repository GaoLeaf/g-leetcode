package cn.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <B>字符串中的第一个唯一字符</B>
 * <p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。</p>
 *
 * @author gaowenjin
 * @date 2020/12/23
 * @description:
 */
public class firstUniqueCharacterInAString_387 {

    @Test
    public void  test() {

        System.out.println(firstUniqCharByMap("leetcode"));
        System.out.println(firstUniqCharByMap("loveleetcode"));
        System.out.println(firstUniqCharByMap("lovelove"));

    }

    /**
     * 通过Map缓存字符及字符出现的次数
     * 时间复杂度：O(n)
     * 空间复杂度：O(∣Σ∣)
     * @param s
     * @return
     */
    public int firstUniqCharByMap(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        char[] chars = s.toCharArray();

        // 缓存字符
        for (char c : chars) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i< chars.length; i++) {
            // 获取第一个只在字符串中出现一次的字符
            if (charMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;

    }

}
