package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值的后序遍历。
 */

public class LintCode068 {


    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     * 递归
     * 您的提交打败了 68.80% 的提交!
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }


    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     * no 递归
     * 您的提交打败了 91.00% 的提交!
     */
    public List<Integer> postorderTraversal_two(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        treeNodeList.add(root);
        while (treeNodeList.size() != 0) {
            TreeNode tmp = treeNodeList.remove(0);
            if (tmp != null) {
                if (tmp.left == null && tmp.right == null) {
                    list.add(tmp.val);
                    continue;
                }


                TreeNode left = tmp.left;
                TreeNode right = tmp.right;

                tmp.left = null;
                tmp.right = null;
                treeNodeList.add(0, tmp);

                if (right != null)
                    treeNodeList.add(0, right);

                if (left != null)
                    treeNodeList.add(0, left);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        LintCode068 lintCode068 = new LintCode068();
        List<Integer> list = lintCode068.postorderTraversal(treeNode);
        P.pln(list);

        list = lintCode068.postorderTraversal_two(treeNode);
        P.pln(list);
    }
}
