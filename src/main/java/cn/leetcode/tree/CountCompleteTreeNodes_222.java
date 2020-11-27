package cn.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * <B>完全二叉树的节点个数</B>
 * <p>给出一个完全二叉树，求出该树的节点个数。</p>
 * <p>说明：完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。</p>
 *
 * @author gaowenjin
 * @date 2020/11/24
 * @description:
 */
public class CountCompleteTreeNodes_222 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {

        System.out.println(countNodes(treeNode0));
        System.out.println(countNodes(treeNode5));
        System.out.println(countNodes1(treeNode5));

    }

    /**
     * 深度搜索法 + 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(height)
     */
    public int countNodes1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }

    /**
     * 广度搜索法 + 迭代
     * 时间复杂度：O(N)
     * 空间复杂度：O(height)
     */
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);

        int count = 0;

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.pop();
            count++;

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }

        }

        return count;
    }

}
