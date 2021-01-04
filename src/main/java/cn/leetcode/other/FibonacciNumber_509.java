package cn.leetcode.other;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaowenjin
 * @date 2021/1/4
 * @description:
 */
public class FibonacciNumber_509 {

    @Test
    public void test() {
        System.out.println(fib(9));
        System.out.println(fibByCache(9));
    }

    /**
     * 暴力递归
     * @param n
     * @return
     */
    public int fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);

    }


    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 通过MAP缓存
     * @param n
     * @return
     */
    public int fibByCache(int n) {

        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int t = fib(n - 1) + fib(n - 2);
        map.put(n, t);
        return t;

    }

}
