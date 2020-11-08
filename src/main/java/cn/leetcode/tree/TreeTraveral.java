package cn.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author gaowenjin
 * @date 2020/11/8
 * @description:
 */
public class TreeTraveral {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    // 递归
    @Test
    public void testByRecursion() {

        preOrderTraveral(treeNode5);
        System.out.println();
        inOrderTraveral(treeNode5);
        System.out.println();
        postOrderTraveral(treeNode5);
        System.out.println();
        levelOrderTraveral(treeNode5);

    }

    // 栈
    @Test
    public void testByStack() {

        preOrderTraveralByStack(treeNode5);
        System.out.println();
        inOrderTraveralByStack(treeNode5);
        System.out.println();
        postOrderTraveralByStack(treeNode5);

    }

    // 前序遍历 根左右
    public void preOrderTraveral(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.val);
        preOrderTraveral(treeNode.left);
        preOrderTraveral(treeNode.right);

    }

    // 中序遍历 左根右
    public void inOrderTraveral(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        inOrderTraveral(treeNode.left);
        System.out.print(treeNode.val);
        inOrderTraveral(treeNode.right);

    }

    // 后序遍历 左右根
    public void postOrderTraveral(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        postOrderTraveral(treeNode.left);
        postOrderTraveral(treeNode.right);
        System.out.print(treeNode.val);

    }

    // 层序遍历
    public void levelOrderTraveral(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(treeNode);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            System.out.print(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

        }

    }

    // 前序遍历 根左右
    public void preOrderTraveralByStack(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();

        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                System.out.print(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop().right;
            }

        }

    }

    // 中序遍历 左根右
    public void inOrderTraveralByStack(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();

        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.val);
                treeNode = treeNode.right;
            }

        }

    }

    // 后序遍历 左右根
    public void postOrderTraveralByStack(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();

                // 判断该节点是否有右节点
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val);
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }

            }

        }

    }

}
