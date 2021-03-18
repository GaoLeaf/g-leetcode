package cn.free.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * <B>大鱼吃小鱼</B>
 *
 * <p>在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向
 * （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:</p>
 * <p>1. 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离</p>
 * <p>2. 当方向相对时，大鱼会吃掉小鱼；</p>
 * <p>3. 鱼的大小都不一样。</p>
 *
 * @author gaowenjin
 * @date 2021/3/18
 * @description:
 */
public class BigFishEatSmallFish {

    @Test
    public void test() {

        int[] Size = {4, 2, 5, 3, 1};
        int[] Dir = {1, 1, 0, 0, 0};

        System.out.println(solution(Size, Dir));

    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param Size
     * @param Dir
     * @return
     */
    public int solution(int[] Size, int[] Dir) {

        int len = Size.length;
        if (len <= 1) {
            return len;
        }

        Stack<Integer> stack = new Stack();
        int direction = Dir[0]; // 鱼的方向

        for (int i = 0; i < len; i++) {

            // 如果鱼的方向和当前鱼的方向一致，加入栈
            if (direction == Dir[i]) {
                stack.push(Size[i]);
                continue;
            }

            // 如果鱼的方向和当前鱼的方向一致，说明相遇了，比较大小
            while (stack.peek() < Size[i]) {

                // 栈顶鱼被吃掉了，弹出元素
                stack.pop();
                // 如果栈为空，说明栈中没有比它更大的鱼，加入栈，重置鱼的方向，退出循环
                if (stack.isEmpty()) {
                    stack.push(Size[i]);
                    direction = Dir[i];
                    break;
                }

            }

        }

        return stack.size();

    }
}
