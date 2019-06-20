package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 * <p>
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 */
public class LintCode088 {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "{" + val + "}";
        }
    }

    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     *
     *      {-2,10,#,2,3,4,#,#,5,6,#,#,7,8,#,#,9}
6
9

提供的数据不对
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        List<TreeNode> listA = new ArrayList<TreeNode>();
        findA(root, A, listA);
        List<TreeNode> listB = new ArrayList<TreeNode>();
        findA(root, B, listB);
        P.pln(A + " - " + listA);
        P.pln(B + " - " + listB);
        for (TreeNode treeNode : listA) {
            for (TreeNode node : listB) {
                if (treeNode == node) {
                    return node;
                }
            }
        }

        return null;
    }

    private void findA(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root.val == target.val) {
            list.add(0, root);
        } else if (root.val > target.val) {
            if (root.left != null) {
                list.add(0, root);
                findA(root.left, target, list);
            }
        } else {
            if (root.right != null) {
                list.add(0, root);
                findA(root.right, target, list);
            }
        }
    }


    public static void main(String[] args) {
        LintCode088 lintCode088 = new LintCode088();
        //      4
        //     / \
        //    3   7
        //       / \
        //      5   6

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode ss = lintCode088.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5));
        P.pln(ss);
    }
}
