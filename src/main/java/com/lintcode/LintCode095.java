package com.lintcode;

import com.utils.P;

/**
 * 描述
 * 中文
 * English
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * <p>
 * 一棵BST定义为：
 * <p>
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 */

public class LintCode095 {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     *
     * 您的提交打败了 93.60% 的提交!
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) return true;
        boolean[] flag = new boolean[1];
        flag[0] = true;
        isValidBST(null, root, flag);
        return flag[0];
    }

    private void isValidBST(TreeNode parent, TreeNode root, boolean[] flag) {
        if (!flag[0]) return;
        if (root.left != null && root.right != null) {

            if (root.val > root.left.val && root.val < root.right.val) {
                if (parent == null) {
                    isValidBST(root, root.left, flag);
                    isValidBST(root, root.right, flag);
                } else {
                    if (parent.left == root) {
                        //左子树
                        if (parent.val > root.right.val) {
                            isValidBST(root, root.right, flag);
                            isValidBST(root, root.left, flag);
                        } else {
                            flag[0] = false;
                        }
                    } else {
                        //右子树
                        if (parent.val < root.left.val) {
                            isValidBST(root, root.right, flag);
                            isValidBST(root, root.left, flag);
                        } else {
                            flag[0] = false;
                        }
                    }
                }
            } else {
                flag[0] = false;
            }

        } else if (root.left != null) {
            if (root.val > root.left.val) {
                if (parent == null) {
                    isValidBST(root, root.left, flag);
                } else {
                    if (parent.left == root) {
                        isValidBST(root, root.left, flag);
                    } else {
                        if (parent.val < root.left.val) {
                            isValidBST(root, root.left, flag);
                        } else {
                            flag[0] = false;
                        }
                    }
                }

            } else {
                flag[0] = false;
            }

        } else if (root.right != null) {
            if (root.val < root.right.val) {
                if (parent == null) {
                    isValidBST(root, root.right, flag);
                } else {
                    if (parent.right == root) {
                        isValidBST(root, root.right, flag);
                    } else {
                        if (parent.val > root.right.val) {
                            isValidBST(root, root.right, flag);
                        } else {
                            flag[0] = false;
                        }
                    }
                }
            } else {
                flag[0] = false;
            }
        } else {

        }
    }

    public static void main(String[] args) {
        LintCode095 lintCode095 = new LintCode095();
        //{-1}
        TreeNode root = new TreeNode(-1);
        boolean ss = lintCode095.isValidBST(root);
        P.pln(ss);
    }
}
