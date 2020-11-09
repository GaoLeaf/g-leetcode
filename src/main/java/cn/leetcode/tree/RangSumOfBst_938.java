package cn.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>二叉搜索树的范围和</p>
 * <p>给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。</p>
 * <p>二叉搜索树保证具有唯一的值。</p>
 *
 * @author gaowenjin
 * @date 2020/11/8
 * @description:
 */
public class RangSumOfBst_938 {

    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(treeNode1, treeNode2, 4);
    TreeNode treeNode7 = new TreeNode(7);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode7, 5);

    @Test
    public void test() {
        System.out.println(dfs(treeNode5, 1, 10));
        System.out.println(bfs(treeNode5, 1, 10));
        System.out.println(dfs(treeNode5, 7, 10));
        System.out.println(bfs(treeNode5, 7, 10));
    }

    // 如果low大于val，查右节点
    // 如果high小于val，查左节点
    // 如果val在区间内，添加值，继续遍历左右节点
    public int dfs(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        // 当前值 < low  --> 右子树
        if (root.val < low) {
            return dfs(root.right, low, high);
        }
        // 当前值 > high --> 左子树
        if (root.val > high) {
            return dfs(root.left, low, high);
        }

        // low < val < high
        return root.val + dfs(root.left, low, high) + dfs(root.right, low, high);
    }

    public int bfs(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {

            root = queue.poll();

            if (root == null) {
                continue;
            }

            // val < low --> 右节点
            if (root.val < low) {
                queue.add(root.right);
            } else if (root.val > high) {
                // val > high --> 左节点
                queue.add(root.left);
            } else {
                // low < val < high
                sum += root.val;
                queue.add(root.right);
                queue.add(root.left);
            }


        }

        return sum;
    }

}
