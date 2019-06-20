package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 * <p>
 * 挑战1：只使用一个队列去实现它
 * <p>
 * 挑战2：用BFS算法来做
 */

public class LintCode069 {

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
     * @return: Level order a list of lists of integer
     * 用队列的方式解决
     * BFS
     * 您的提交打败了 91.60% 的提交!
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                    lists.add(list);
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
        LintCode069 lintCode069 = new LintCode069();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode = null;
        List<List<Integer>> lists = lintCode069.levelOrder(treeNode);
        P.pln(lists);
    }
}
