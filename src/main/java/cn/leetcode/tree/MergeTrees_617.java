package cn.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <B>给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。</B>
 *
 * <p>你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。</p>
 *
 * <p>注意: 合并必须从两个树的根节点开始。</p>
 * <p>
 * <br/>
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author gaowenjin
 * @date 2020/11/5
 * @description:
 */
public class MergeTrees_617 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {
        System.out.println(mergeTrees(treeNode1, treeNode4));
        System.out.println(mergeTreesByBfs(treeNode1, treeNode4));
        System.out.println(mergeTrees(treeNode5, treeNode4));
        System.out.println(mergeTreesByBfs(treeNode5, treeNode4));
        System.out.println(mergeTrees(treeNode5, treeNode1));
        System.out.println(mergeTreesByBfs(treeNode5, treeNode1));
    }

    /**
     * 深度优先搜索法 <br/>
     * 时间复杂度 递归了n个节点 O(min(m,n))
     * 空间复杂度 二叉树的高度 O(min(m,n))
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        // 节点都有，值相加
        TreeNode mergeNode = new TreeNode(t1.val + t2.val);

        // 左节点
        mergeNode.left = mergeTrees(t1.left, t2.left);

        // 右节点
        mergeNode.right = mergeTrees(t1.right, t2.right);

        return mergeNode;

    }

    /**
     * 广度优先搜索法 <br/>
     * 时间复杂度 O(min(m,n))
     * 空间复杂度 O(min(m,n))
     */
    public TreeNode mergeTreesByBfs(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        Queue<TreeNode> q = new LinkedList<>(), q1 = new LinkedList<>(), q2 = new LinkedList<>();

        TreeNode mergeNode = new TreeNode(t1.val + t2.val);

        q.offer(mergeNode);
        q1.offer(t1);
        q2.offer(t2);

        while (!q1.isEmpty() || !q2.isEmpty()) {

            TreeNode q_node = q.poll(), q1_node = q1.poll(), q2_node = q2.poll();

            TreeNode q1_left = q1_node.left, q1_right = q1_node.right,
                    q2_left = q2_node.left, q2_right = q2_node.right;

            if (q1_left != null || q2_left != null) {
                if (q1_left != null && q2_left != null) {
                    q1.offer(q1_left);
                    q2.offer(q2_left);
                    TreeNode q_left = new TreeNode(q1_left.val + q2_left.val);
                    q_node.left = q_left;
                    q.offer(q_left);
                } else if (q1_left != null) {
                    q_node.left = q1_left;
                } else if (q2_left != null) {
                    q_node.left = q2_left;
                }
            }

            if (q1_right != null || q2_right != null) {

                if (q1_right != null && q2_right != null) {
                    q1.offer(q1_right);
                    q2.offer(q2_right);
                    TreeNode q_right = new TreeNode(q1_right.val + q2_right.val);
                    q_node.right = q_right;
                    q.offer(q_right);
                } else if (q1_right != null) {
                    q_node.right = q1_right;
                } else if (q2_right != null) {
                    q_node.right = q2_right;
                }

            }

        }

        return mergeNode;

    }

}
