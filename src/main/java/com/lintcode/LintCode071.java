package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 */
public class LintCode071 {

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
     * <p>
     * 您的提交打败了 86.60% 的提交!
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // write your code here
        TreeNode nullT = new TreeNode(0);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        treeNodes.add(root);
        treeNodes.add(nullT);
        boolean falg = true;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> tmp_list = new ArrayList<Integer>();
        while (treeNodes.size() != 0) {
            TreeNode tmp = treeNodes.remove(0);
            if (tmp == nullT) {
                if (list.size() != 0) {
                    if (falg) {
                        lists.add(list);
                    } else {
                        tmp_list = new ArrayList<Integer>();
                        for (int i = list.size() - 1; i >= 0; i--) {
                            tmp_list.add(list.get(i));
                        }

                        lists.add(tmp_list);
                    }
                    //falg = !falg;
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
        LintCode071 lintCode071 = new LintCode071();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(6);
        //treeNode = null;
        List<List<Integer>> lists = lintCode071.zigzagLevelOrder(treeNode);
        P.pln(lists);
    }
}
