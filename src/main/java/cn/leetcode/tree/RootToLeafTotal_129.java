package cn.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <B>给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。</B>
 *
 * <p>例如，从根到叶子节点路径 1->2->3 代表数字 123。</p>
 * <p>计算从根到叶子节点生成的所有数字之和。</p>
 * <p>说明: 叶子节点是指没有子节点的节点。</p>
 * <p>
 * <br/>
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 *
 * @author gaowenjin
 * @date 2020/11/4
 * @description:
 */
public class RootToLeafTotal_129 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {

        // 深度优先搜索法
        System.out.println(dfs(treeNode1, 0));
        System.out.println(bfs(treeNode1));
        System.out.println(dfs(treeNode4, 0));
        System.out.println(bfs(treeNode4));
        System.out.println(dfs(treeNode5, 0));
        System.out.println(bfs(treeNode5));

    }

    /**
     * 深度优先搜索法 <br/>
     * 时间复杂度 递归了n个节点 O(n)
     * 空间复杂度 二叉树的高度 O(n)
     */
    public int dfs(TreeNode treeNode, int sum) {

        if (treeNode == null) {
            return 0;
        }

        int total = sum * 10 + treeNode.val;

        if (treeNode.left == null && treeNode.right == null) {
            return total;
        }

        return dfs(treeNode.left, total) + dfs(treeNode.right, total);

    }

    /**
     * 广度优先搜索法 <br/>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int bfs(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();

        nodeQueue.offer(treeNode);
        numQueue.offer(treeNode.val);

        int sum = 0;

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left == null && right == null) {
                sum += num;
            } else {

                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }

                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }

        }

        return sum;
    }

}
