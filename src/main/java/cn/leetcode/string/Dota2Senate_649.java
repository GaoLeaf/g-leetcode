package cn.leetcode.string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <B> Dota2 参议院</B>
 *
 * <p>Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)</p>
 * <p>Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：</p>
 * <p>1. 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。</p>
 * <p>2. 宣布胜利：如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。</p>
 * <p>给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。</p>
 * <p>以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。</p>
 * <p>假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。</p>
 *
 * @author gaowenjin
 * @date 2020/12/11
 * @description:
 */
public class Dota2Senate_649 {

    @Test
    public void test() {
        System.out.println(predictPartyVictory("DDR"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("DDRR"));
        System.out.println(predictPartyVictory("RDDRRRRRRRDDD"));
    }

    public String predictPartyVictory(String senate) {

        if (senate == null) {
            return "";
        }

        Queue<Integer> radiant = new LinkedList();
        Queue<Integer> dire = new LinkedList();

        int len = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {

            Integer r = radiant.poll();
            Integer d = dire.poll();

            if (r > d) {
                dire.offer(d + len);
            } else {
                radiant.offer(r + len);
            }

            /**
             * 错误版本：前面的参议员可以禁止对方阵营参议员的权力
             * 应该将该参议员移至队列尾部
             *
            if (radiant.peek() > dire.peek()) {
                radiant.poll();
            } else {
                dire.poll();
            }*/

        }

        System.out.println("r" + radiant);
        System.out.println("d" + dire);

        return radiant.isEmpty() ? "Dire" : "Radiant";

    }

}
