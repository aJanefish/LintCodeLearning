package com.lintcode;

import com.utils.P;

/**
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * <p>
 * 你需要保证该树仍然是一棵二叉查找树。
 * <p>
 * 挑战
 * 能否不使用递归？
 */

public class LintCode085 {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "{" + val +
                    ", " + left +
                    "," + right +
                    '}';
        }
    }

    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     *
     * 您的提交打败了 99.20% 的提交!
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null)
            return node;
        insertNode_my(root, node);
        return root;
    }

    public void insertNode_my(TreeNode root, TreeNode node) {
        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                insertNode_my(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insertNode_my(root.right, node);
            }
        }
    }


    public static void main(String[] args) {

        LintCode085 lintCode085 = new LintCode085();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        TreeNode ss = lintCode085.insertNode(root, new TreeNode(6));
        P.pln(ss);
    }
}
