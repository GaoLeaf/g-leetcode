package cn.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 翻转一棵二叉树。
 *
 * @author gaowenjin
 * @date 2020/11/16
 * @description:
 */
public class InvertBinaryTree_226 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {

        System.out.println(treeNode5);
//        System.out.println(invertTreeByBfs(treeNode5));
        System.out.println(invertTreeByDfs(treeNode5));

    }

    public TreeNode invertTreeByDfs(TreeNode root) {

        if (root == null) {
            return null;
        }

        // 临时节点
        TreeNode tempNode = root.left;

        // 左右节点交换
        root.left = invertTreeByBfs(root.right);
        root.right = invertTreeByDfs(tempNode);

        return root;

    }

    /**
     * 广度优先搜索法 <br/>
     * 时间复杂度 O(min(m,n))
     * 空间复杂度 O(min(m,n))
     */
    public TreeNode invertTreeByBfs(TreeNode root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            // 临时节点
            TreeNode tempNode = node.left;

            // 左右节点交换
            node.left = node.right;
            node.right = tempNode;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }

        return root;

    }

}
