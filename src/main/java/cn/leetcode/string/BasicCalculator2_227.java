package cn.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <B>基本计算器 2</B>
 *
 * <p>给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。</p>
 * <p>整数除法仅保留整数部分。</p>
 * <p>s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开</p>
 *
 * @author gaowenjin
 * @date 2021/3/12
 * @description:
 */
public class BasicCalculator2_227 {

    @Test
    public void test() {

        Assert.assertEquals(5, calculate("2+3"));
        Assert.assertEquals(3, calculate("6-3"));
        Assert.assertEquals(2, calculate("6/3"));
        Assert.assertEquals(4, calculate("2+6/3"));
        Assert.assertEquals(4, calculate("2+6/3*2-2"));
        Assert.assertEquals(5, calculate(" 3+5 / 2 "));

    }

    /**
     * 时间复杂度： 最好 O(1) 最坏 O(n)  平均 O(n)，取决于字符串的长度
     * 空间复杂度： 最好 O(1) 最坏 O(n)  平均 O(n)，取决于栈的空间
     *
     * @param s
     * @return
     */
    public int calculate(String s) {

        Deque<Integer> deque = new LinkedList();

        int num = 0;
        int len = s.length();
        char c = '+';

        for (int i = 0; i < len; i++) {

            if (i < len && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            // 当字符不是数字，或者是最后一个字符时进入
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len -1) {
                switch (c) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push((-1) * num);
                        break;
                    case '*':
                        Integer j = deque.poll();
                        deque.push(j * num);
                        break;
                    case '/':
                        Integer k = deque.poll();
                        deque.push(k / num);
                }
                c = s.charAt(i);
                num = 0;
            }
        }

        int ret = 0;
        while (!deque.isEmpty()) {
            ret += deque.poll();
        }

        return ret;
    }

}
