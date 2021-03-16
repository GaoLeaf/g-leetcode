package cn.free.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：</p>
 * <p>1. 左括号必须用相同类型的右括号闭合</p>
 * <p>2. 左括号必须以正确的顺序闭合</p>
 * <p>3. 注意空字符串可被认为是有效字符串</p>
 *
 * @author gaowenjin
 * @date 2021/3/16
 * @description:
 */
public class MultipleRightfulBracket {

    @Test
    public void test() {

        String s1 = "";
        Assert.assertEquals(true, isVaild(s1));
        System.out.println(s1 + "核对完成");

        String s2 = "(){}({})";
        Assert.assertEquals(true, isVaild(s2));
        System.out.println(s2 + "核对完成");

        String s3 = "(){}({[}])";
        Assert.assertEquals(false, isVaild(s3));
        System.out.println(s3 + "核对完成");

        System.out.println("============== END");

    }

    /**
     * 判断字符串括号是否合法
     * 思路：遇到前括号，直接放入到栈中；
     * 遇到后括号，判断栈是否为空，且栈顶元素与前括号匹配，匹配则弹出，否则不匹配
     * 最后判断栈是否为空
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param str
     * @return
     */
    public boolean isVaild(String str) {

        // 当字符串为空时，可以快速返回
        if (str == null || str.length() == 0) {
            return true;
        }

        int len = str.length();
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (len % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);
            // 前括号，直接放入到栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                // 后括号，判断栈是否为空，且栈顶元素与前括号匹配，匹配则弹出，否则不匹配
            } else if (c == ')') {

                if (stack.isEmpty() || stack.peek() == '(') {
                    return false;
                }
                stack.pop();

            } else if (c == ']') {

                if (stack.isEmpty() || stack.peek() == '[') {
                    return false;
                }
                stack.pop();

            } else if (c == '}') {

                if (stack.isEmpty() || stack.peek() == '{') {
                    return false;
                }
                stack.pop();

            }

        }

        // 判断栈元素是否为空
        return stack.isEmpty();

    }
}
