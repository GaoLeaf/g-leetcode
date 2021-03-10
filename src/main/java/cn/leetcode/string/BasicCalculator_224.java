package cn.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <B>基本计算器</B>
 *
 * <p>实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。</p>
 * <p>s 由数字、'+'、'-'、'('、')'、和 ' ' 组成</p>
 *
 * @author gaowenjin
 * @date 2021/3/10
 * @description:
 */
public class BasicCalculator_224 {

    @Test
    public void test() {

        Assert.assertEquals(5, calculate("2+3"));
        Assert.assertEquals(3, calculate("6-3"));
        Assert.assertEquals(5, calculate("2+( 6-3)"));
        Assert.assertEquals(23, calculate("20+(6-3)"));
        Assert.assertEquals(11, calculate("20-(6+3)"));
        Assert.assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));

    }

    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1); // 数字正负标识
        int sign = 1;

        int len = s.length();
        int i = 0; // 字符串位置
        int ret = 0; // 返回值
        while (i < len) {

            if (s.charAt(i) == ' ') { // 去除空格
                i++;
            } else if (s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                stack.push(sign); // 暂存括号前符号
                i++;
            } else if (s.charAt(i) == ')') {
                stack.pop(); // 弹出括号前符号
                i++;
            } else {
                int num = 0;
                // 非个位数，需要拼接转换
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }

        }

        return ret;
    }

}
