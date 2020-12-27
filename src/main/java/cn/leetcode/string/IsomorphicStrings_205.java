package cn.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <B>同构字符串</B>
 * <p>给定两个字符串 s 和 t，判断它们是否是同构的。</p>
 * <p>如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。</p>
 * <p>所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。</p>
 *
 * @author gaowenjin
 * @date 2020/12/27
 * @description:
 */
public class IsomorphicStrings_205 {

    @Test
    public void test() {

        System.out.println("ab - aa = " + isIsomorphicByArray2("ab", "aa"));
        System.out.println("abaca - abacc = " + isIsomorphicByArray2("abaca", "abacc"));
        System.out.println("egg - add = " + isIsomorphicByArray2("egg", "add"));
        System.out.println("foo - bar = " + isIsomorphicByArray2("foo", "bar"));
        System.out.println("paper - title = " + isIsomorphicByArray2("paper", "title"));

    }

    /**
     * 两个Map分别将两个字符串作为key-value
     * 比较两个map的key及value是否对应
     * 时间复杂度：O(n)
     * 空间复杂度：O(∣Σ∣)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < sLen; i++) {

            char as = s.charAt(i), at = t.charAt(i);
            if ((sMap.containsKey(as) && sMap.get(as) != at) || (tMap.containsKey(at) && tMap.get(at) != as)) {
                return false;
            }
            sMap.put(as, at);
            tMap.put(at, as);

        }

        return true;
    }

    /**
     * 将上例中两个Map合成一个Map
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();

        for (int i = 0; i < sLen; i++) {

            char as = s.charAt(i), at = t.charAt(i);
            if (sMap.containsKey(as)) { // map中包含a

                if (sMap.get(as) != at) { // 对应的map值不匹配
                    return false;
                }

            } else {

                if (sMap.containsValue(at)) { // map的值中包含
                    return false;
                }

                sMap.put(as, at);

            }

        }

        return true;

    }

    /**
     * 将上例中map替换为数组，但不适用与汉字字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphicByArray(String s, String t) {
        return a2b(s, t) && a2b(t ,s);
    }

    /**
     * 以s为数组索引，搜索t
     * @param s
     * @param t
     * @return
     */
    private boolean a2b(String s, String t) {
        int[] arr = new int[128];

        for (int i = 0; i < s.length(); i++) {

            char as = s.charAt(i), at = t.charAt(i);
            if (arr[as] == 0) {
                arr[as] = at;
            } else {
                if (arr[as] != at) {
                    return false;
                }
            }

        }

        return true;
    }

    public boolean isIsomorphicByArray2(String s, String t) {

        int[] sArr = new int[128];
        int[] tArr = new int[128];

        for (int i = 0; i < s.length(); i++) {

            char as = s.charAt(i), at = t.charAt(i);

            // 两个数组数据都不存在时，加入到数组中
            if (sArr[as] == 0 && tArr[at] == 0) {
                sArr[as] = at;
                tArr[at] = as;
            } else if (sArr[as] == 0 || tArr[at] == 0 || sArr[as] != at || tArr[at] != as) {
                // 两个数组有且只有一个数据为空时 --> false
                // 两个数组数据都不为空时，判断数据数据是否符合要求
                return false;
            }

        }

        return true;

    }

}
