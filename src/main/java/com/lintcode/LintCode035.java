package com.lintcode;

import com.utils.P;

/**
 * 翻转一个链表
 * <p>
 * 样例 1:
 * <p>
 * 输入: 1->2->3->null
 * 输出: 3->2->1->null
 */

public class LintCode035 {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode new_head = null;
        ListNode old_head = head;
        while (old_head != null) {
            if (new_head == null) {
                new_head = old_head;
                old_head = old_head.next;
                new_head.next = null;
            } else {
                ListNode tmp = old_head.next;
                old_head.next = new_head;
                new_head = old_head;
                old_head = tmp;
            }
        }

        return new_head;
    }


    //Definition for ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void show(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            P.pln(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LintCode035 lintCode035 = new LintCode035();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        show(listNode);
        ListNode listNode1 = lintCode035.reverse(listNode);
        show(listNode1);
    }
}
