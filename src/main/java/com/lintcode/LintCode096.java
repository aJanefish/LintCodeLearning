package com.lintcode;

import com.utils.P;

/**
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * <p>
 * 你应该保留两部分内链表节点原有的相对顺序
 */
public class LintCode096 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     *
     * 您的提交打败了 61.60% 的提交!
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) return null;

        ListNode head_small = null;
        ListNode tail_small = null;

        ListNode head_bigger = null;
        ListNode tail_bigger = null;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                if (head_small == null) {
                    head_small = tmp;
                    tail_small = tmp;
                } else {
                    tail_small.next = tmp;
                    tail_small = tmp;
                }
            } else {
                if (head_bigger == null) {
                    head_bigger = tmp;
                    tail_bigger = tmp;
                } else {
                    tail_bigger.next = tmp;
                    tail_bigger = tmp;
                }
            }
            tmp = tmp.next;
        }

        if (head_small == null) {
            tail_bigger.next = null;
            return head_bigger;
        } else {
            tail_small.next = head_bigger;
            if (tail_bigger != null) {
                tail_bigger.next = null;
            }
            return head_small;
        }
    }



    public static void main(String[] args) {
        //输入: list = 1->4->3->2->5->2->null, x = 3
        //输出: 1->2->2->4->3->5->null

        LintCode096 lintCode096 = new LintCode096();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        //head = null;
        show(head);
        ListNode ss = lintCode096.partition(head, 3);
        show(ss);
    }

    private static void show(ListNode listNode) {

        ListNode tmp = listNode;
        while (tmp != null) {
            P.p(tmp.val + " -> ");
            tmp = tmp.next;
        }
        P.pln("null");
    }
}
