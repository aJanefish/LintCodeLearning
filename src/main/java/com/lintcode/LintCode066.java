package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * 挑战
 * 你能使用非递归实现么？
 */

public class LintCode066 {

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
     * @return: Preorder in ArrayList which contains node values.
     * 您的提交打败了 92.60% 的提交!
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }


    //非递归方法
    //您的提交打败了 83.00% 的提交!
    public List<Integer> preorderTraversal_two(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        treeNodeList.add(root);
        while (treeNodeList.size() != 0) {
            TreeNode tmp = treeNodeList.remove(0);

            if (tmp != null){
                list.add(tmp.val);

                if (tmp.right != null)
                    treeNodeList.add(0, tmp.right);
                if (tmp.left != null)
                    treeNodeList.add(0, tmp.left);
            }


        }
        return list;
    }


    public static void main(String[] args) {
        LintCode066 lintCode066 = new LintCode066();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode = null;
        List<Integer> list = lintCode066.preorderTraversal(treeNode);
        P.pln(list);

        list = lintCode066.preorderTraversal_two(treeNode);
        P.pln(list);
    }
}
