package cn.leetcode.tree;

import org.junit.Test;

/**
 * <p>二叉搜索树中的搜索</p>
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * <br/>
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author gaowenjin
 * @date 2020/10/28
 * @description:
 */
public class SearchSubTree_700 {

    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(treeNode1, treeNode2, 4);
    TreeNode treeNode7 = new TreeNode(7);
    TreeNode treeNode5 = new TreeNode(treeNode4, treeNode7, 5);

    @Test
    public void test() {

        System.out.println(searchBST(treeNode5, 1));
        System.out.println(searchBSTByIteration(treeNode5, 1));

        System.out.println(searchBST(treeNode5, 6));
        System.out.println(searchBSTByIteration(treeNode5, 6));

        System.out.println(searchBST(treeNode1, 1));
        System.out.println(searchBSTByIteration(treeNode1, 1));

    }


    /**
     * <p>题解要点：</p>
     * <p>1. 了解二叉搜索树的特性</p>
     * <p>每个节点的值大于左子树上任意一个节点的值</p>
     * <p>每个节点的值小于右子树上任意一个节点的值</p>
     */
    private void answerKeyPoints () {
    }

    /**
     * 递归 <br/>
     * 时间复杂度 递归了树的高度，O(N) <br/>
     * 空间复杂度 递归栈的深度，O(n)
     */
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        return searchBST((root.val > val ? root.left : root.right), val);
    }

    /**
     * 迭代 <br/>
     * 时间复杂度 递归了树的高度，O(n)<br/>
     * 空间复杂度 恒定的额外空间，O(1)
     */
    public TreeNode searchBSTByIteration(TreeNode root, int val) {

        while (root != null) {

            if (root.val == val) {
                return root;
            }

            root = root.val > val ? root.left : root.right;
        }

        return null;
    }

}
