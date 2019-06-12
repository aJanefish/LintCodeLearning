package com.lintcode;

import com.utils.P;

/**
 * 翻转链表中第m个节点到第n个节点的部分
 * <p>
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 输出: 1->4->3->2->5->NULL.
 */

public class LintCode036 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: ListNode head is the head of the linked list
     * @param m:    An integer
     * @param n:    An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        //分为三部分


        int index = 1;
        ListNode tail_first = null;
        ListNode current = head;
        while (index < m) {
            tail_first = current;
            current = current.next;
            index++;
        }
        P.pln("current - " + current.val);


        //从current开始反转到(n - m)
        //记录反转过后的尾部
        ListNode tail = current;

        int num = 0;
        ListNode new_head = null;
        ListNode next = null;
        while (num <= (n - m)) {
            if (new_head == null) {
                new_head = current;
                current = current.next;
                new_head.next = null;
                next = current;
            } else {
                next = current.next;
                current.next = new_head;
                new_head = current;
                current = next;
            }
            num++;
        }


        P.pln("next:" + next.val);
        P.pln("tail:" + tail.val);
        if(next != null) {
            tail.next = next;
        }


        if (tail_first != null) {
            tail_first.next = new_head;
            return head;
        }

        return new_head;
    }

    //单链表
    // * 输入: 1->2->3->4->5->NULL, m = 2 and n = 4,
    // * 输出: 1->4->3->2->5->NULL.

    public static void show(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            P.pln(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LintCode036 lintCode036 = new LintCode036();
        //3760->2881->7595->3904->5069->4421->8560->8879->8488->5040->5792->56->1007->2270->3403->6062->null
        ListNode listNode = new ListNode(3760);
        listNode.next = new ListNode(2881);
        listNode.next.next = new ListNode(7595);
        listNode.next.next.next = new ListNode(3904);
        listNode.next.next.next.next = new ListNode(5069);
        listNode.next.next.next.next.next = new ListNode(4421);
        listNode.next.next.next.next.next.next = new ListNode(8560);
        listNode.next.next.next.next.next.next.next = new ListNode(8879);
        listNode.next.next.next.next.next.next.next.next = new ListNode(8488);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(5040);
        listNode.next.next.next.next.next.next.next.next.next.next = new ListNode(5792);
        listNode.next.next.next.next.next.next.next.next.next.next.next = new ListNode(56);
        listNode.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1007);
        listNode.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(2270);
        listNode.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(3403);
        listNode.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6062);


        show(listNode);
        ListNode ss = lintCode036.reverseBetween(listNode, 2, 7);
        show(ss);
    }
}
