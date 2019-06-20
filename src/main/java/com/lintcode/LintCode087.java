package com.lintcode;

import com.utils.P;

/**
 * 给定一棵具有不同节点值的二叉查找树，删除树中与给定值相同的节点。如果树中没有相同值的节点，就不做任何处理。你应该保证处理之后的树仍是二叉查找树。
 */

public class LintCode087 {

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
                    '}';
        }
    }

    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     *
     * 您的提交打败了 40.60% 的提交!

     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here

        if (root == null)
            return null;

        if (root.val == value) {
            //左转
            if (root.right != null && root.left != null) {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.left = root.left;
                root = root.right;
            } else if (root.left != null) {

                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                return null;
            }
        } else {
            if (root.val > value) {
                remove(root, root.left, value);
            } else {
                remove(root, root.right, value);
            }

        }
        return root;
    }

    private void remove(TreeNode parent, TreeNode root, int value) {
        if (root.val == value) {
            if (parent.left == root) {
                if (root.right != null && root.left != null) {
                    TreeNode tmp = root.right;
                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }
                    tmp.left = root.left;
                    root = root.right;
                    parent.left = root;
                } else if (root.left != null) {

                    root = root.left;
                    parent.left = root;
                } else if (root.right != null) {
                    root = root.right;
                    parent.left = root;
                } else {
                    parent.left = null;
                    return;
                }
            } else {
                if (root.right != null && root.left != null) {
                    TreeNode tmp = root.right;
                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }
                    tmp.left = root.left;
                    root = root.right;
                    parent.right = root;
                } else if (root.left != null) {
                    root = root.left;
                    parent.right = root;
                } else if (root.right != null) {
                    root = root.right;
                    parent.right = root;
                } else {
                    parent.right = null;
                    return;
                }
            }
        }

        if (value < root.val) {
            if (root.left == null) {
                return;
            } else {
                remove(root, root.left, value);
            }
        } else {
            if (root.right == null) {
                return;
            } else {
                remove(root, root.right, value);
            }

        }
    }

    public static void main(String[] args) {
        LintCode087 lintCode087 = new LintCode087();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(100);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(99);
        root.right.left.right.left = new TreeNode(30);
        root.right.left.right.left.right = new TreeNode(98);
        root.right.left.right.left.right.left = new TreeNode(40);
        root.right.left.right.left.right.left.right = new TreeNode(97);
        TreeNode ss = lintCode087.removeNode(root, 30);
        P.pln(ss);
    }
}
