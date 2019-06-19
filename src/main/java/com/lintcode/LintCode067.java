package com.lintcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树,返回其中序遍历
 * <p>
 * 你能使用非递归算法来实现么?
 */
public class LintCode067 {
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
     * @return: Inorder in ArrayList which contains node values.
     * 递归
     * 您的提交打败了 80.60% 的提交!
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     * 非递归
     * 您的提交打败了 80.60% 的提交!
     */
    public List<Integer> inorderTraversal_two(TreeNode root) {
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
                if (right != null)
                    treeNodeList.add(0, right);
                tmp.left = null;
                tmp.right = null;
                treeNodeList.add(0, tmp);
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
        LintCode067 lintCode067 = new LintCode067();
        List<Integer> list = lintCode067.inorderTraversal(treeNode);
        P.pln(list);
        list = lintCode067.inorderTraversal_two(treeNode);
        P.pln(list);

    }
}
