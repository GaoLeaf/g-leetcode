package cn.leetcode.array;

import org.junit.Test;

/**
 * <B>柠檬水找零</B>
 *
 * <p>在柠檬水摊上，每一杯柠檬水的售价为 5 美元。</p>
 * <p>顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。</p>
 * <p>每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。</p>
 * <p>注意，一开始你手头没有任何零钱。</p>
 * <p>如果你能给每位顾客正确找零，返回 true ，否则返回 false 。</p>
 *
 * @author gaowenjin
 * @date 2020/12/10
 * @description:
 */
public class lemonadeChange_860 {

    @Test
    public void test() {

        int[] l = new int[]{5, 5, 10, 10, 20};
        int[] l1 = new int[]{5, 5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(l));
        System.out.println(lemonadeChange(l1));

    }

    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int bill : bills) {

            if (bill == 5) { // 支付5元
                five++;
            } else if (bill == 10) { // 支付 10元

                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else { // 支付20元

                // 优先给客户10元和5元，如果没有再判断是否有3张5元的
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }

            }

        }

        return true;
    }
}
