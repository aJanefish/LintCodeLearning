package com.lintcode;

import com.utils.P;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的距离。
 */
public class LintCode097 {
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
     * @return: An integer
     *
     * 您的提交打败了 97.20% 的提交!
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int[] depth = new int[1];
        depth[0] = 1;

        maxDepth(depth, root, 1);
        return depth[0];
    }

    private void maxDepth(int[] depths, TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (depths[0] < depth) {
                depths[0] = depth;
                return;
            }
        }
        maxDepth(depths, root.left, depth + 1);
        maxDepth(depths, root.right, depth + 1);
    }

    public static void main(String[] args) {
        LintCode097 lintCode097 = new LintCode097();
        //   1
        //  / \
        // 2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        int ss = lintCode097.maxDepth(root);
        P.pln(ss);
    }
}
