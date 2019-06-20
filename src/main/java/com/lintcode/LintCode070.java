package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 */
public class LintCode070 {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     *
     * 您的提交打败了 52.20% 的提交!
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        TreeNode nullT = new TreeNode(0);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        treeNodes.add(root);
        treeNodes.add(nullT);
        List<Integer> list = new ArrayList<Integer>();
        while (treeNodes.size() != 0) {
            TreeNode tmp = treeNodes.remove(0);
            if (tmp == nullT) {
                if (list.size() != 0) {
                    lists.add(0, list);
                    list = new ArrayList<Integer>();
                }
                if (treeNodes.size() != 0) {
                    treeNodes.add(nullT);
                }
                continue;
            }

            if (tmp != null) {
                list.add(tmp.val);
                if (tmp.left != null)
                    treeNodes.add(tmp.left);
                if (tmp.right != null)
                    treeNodes.add(tmp.right);
            }

        }
        return lists;
    }

    public static void main(String[] args) {
        LintCode070 lintCode070 = new LintCode070();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        //treeNode = null;
        List<List<Integer>> lists = lintCode070.levelOrderBottom(treeNode);
        P.pln(lists);
    }
}
