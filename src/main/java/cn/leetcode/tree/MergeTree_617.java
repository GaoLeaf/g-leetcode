package cn.leetcode.tree;

import org.junit.Test;

/**
 * <B>给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。</B>
 *
 * <p>你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。</p>
 *
 * <p>注意: 合并必须从两个树的根节点开始。</p>
 *
 * <br/>
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author gaowenjin
 * @date 2020/11/5
 * @description:
 */
public class MergeTree_617 {

    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(null, treeNode0, 3);
    TreeNode treeNode4 = new TreeNode(treeNode2, treeNode1, 4);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode3, 5);

    @Test
    public void test() {
        System.out.println(mergeTrees(treeNode1, treeNode4));
        System.out.println(mergeTrees(treeNode5, treeNode4));
        System.out.println(mergeTrees(treeNode5, treeNode1));
    }

    /**
     * 深度优先搜索法 <br/>
     * 时间复杂度 递归了n个节点 O(n)
     * 空间复杂度 二叉树的高度 O(n)
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

}
