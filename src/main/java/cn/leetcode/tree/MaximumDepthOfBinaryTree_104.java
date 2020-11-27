package cn.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <B>二叉树的最大深度</B>
 * <p>给定一个二叉树，找出其最大深度。</p>
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
 * <p>叶子节点是指没有子节点的节点。</p>
 *
 * @author gaowenjin
 * @date 2020/11/23
 * @description:
 */
public class MaximumDepthOfBinaryTree_104 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {

        System.out.print(maxDepth_bfs(treeNode0));
        System.out.print(maxDepth_dfs(treeNode0));
        System.out.println(maxDepth_bfs_v2(treeNode0));

        System.out.print(maxDepth_bfs(treeNode3));
        System.out.print(maxDepth_dfs(treeNode3));
        System.out.println(maxDepth_bfs_v2(treeNode3));

        System.out.print(maxDepth_bfs(treeNode5));
        System.out.print(maxDepth_dfs(treeNode5));
        System.out.println(maxDepth_bfs_v2(treeNode5));

    }

    public int maxDepth_dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth_dfs(root.left), maxDepth_dfs(root.right)) + 1;
    }

    public int maxDepth_bfs_v2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int maxDepth = 0;
        while (!nodes.isEmpty()) {

            int size = nodes.size();
            while (size -- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            maxDepth ++;

        }

        return maxDepth;

    }

    public int maxDepth_bfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>(); // 存放节点
        Stack<Integer> levels = new Stack<>(); // 存放节点等级
        stack.push(root);
        levels.push(1);

        int maxDepth = 0;

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            Integer level = levels.pop();

            if (level > maxDepth) {
                maxDepth = level;
            }

            if (node.left != null) {
                stack.push(node.left);
                levels.push(level + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                levels.push(level + 1);
            }

        }

        return maxDepth;
    }

}
