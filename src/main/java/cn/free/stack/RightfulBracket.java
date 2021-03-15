package cn.free.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <B>判断字符串括号是否合法</B>
 * <p>字符串中只有字符'('和')'。合法字符串需要括号可以配对。</p>
 *
 * @author gaowenjin
 * @date 2021/3/14
 * @description:
 */
public class RightfulBracket {

    @Test
    public void test() {

        String s1 = "()";
        Assert.assertEquals(true, isVaild(s1));
        Assert.assertEquals(true, isVaild_V1(s1));
        System.out.println(s1 + "核对完成");

        String s2 = "(()())()()";
        Assert.assertEquals(true, isVaild(s2));
        Assert.assertEquals(true, isVaild_V1(s2));
        System.out.println(s2 + "核对完成");

        String s3 = "((((";
        Assert.assertEquals(false, isVaild(s3));
        Assert.assertEquals(false, isVaild_V1(s3));
        System.out.println(s3 + "核对完成");

        String s4 = "))))";
        Assert.assertEquals(false, isVaild(s4));
        Assert.assertEquals(false, isVaild_V1(s4));
        System.out.println(s4 + "核对完成");

        /**
         * 边界值测试
         * 1. 空值
         * 2. 字符串只有1个或奇数个
         */
        String s5 = "";
        Assert.assertEquals(true, isVaild(s5));

        String s6 = "(";
        Assert.assertEquals(false, isVaild(s6));

        String s7 = "())";
        Assert.assertEquals(false, isVaild(s7));

        System.out.println("============== END");

    }

    /**
     * 判断字符串括号是否合法
     * 思路： 消除法
     * 1. 当遇到 ( 进行压栈操作
     * 2. 当遇到 ) 进行出栈操作
     *
     * @param str
     */
    public boolean isVaild(String str) {

        // 当字符串为空时，可以快速返回
        if (str == null || str.length() == 0) {
            return true;
        }

        int len = str.length();
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串，该步未曾想到
        if (len % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < len) {

            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 检查栈是否为空，边界值
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            i++;
        }

        return stack.isEmpty();
    }

    /**
     * 判断字符串括号是否合法
     * 思路： 计数器
     * 1. 当遇到 ( 进行 +1
     * 2. 当遇到 ) 进行 -1
     *
     * @param str
     * @return
     */
    public boolean isVaild_V1(String str) {

        // 当字符串为空时，可以快速返回
        if (str == null || str.length() == 0) {
            return true;
        }

        int len = str.length();
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串，该步未曾想到
        if (len % 2 != 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                // 检查栈是否为空，边界值
                if (count == 0) {
                    return false;
                }
                -- count;
            }

        }

        return count == 0;
    }

}
