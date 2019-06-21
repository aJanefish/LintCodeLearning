package com.lintcode;

import com.utils.P;

/**
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 * <p>
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 必须在不改变节点值的情况下进行原地操作。
 */

public class LintCode099 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: The head of linked list.
     * @return: nothing
     *
     * 您的提交打败了 95.40% 的提交!
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) return;
        ListNode small = head;
        ListNode fast = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            small = small.next;
        }
        //找到中心点
        //反转后半段数组
        ListNode next = small.next;
        small.next = null;
        ListNode tmp = null;
        ListNode fast_head = null;
        while (next != null) {
            if (fast_head == null) {
                fast_head = next;
                next = next.next;
                fast_head.next = null;
                continue;
            }

            tmp = next;
            next = next.next;

            tmp.next = fast_head;
            fast_head = tmp;
        }

        show(head);
        show(fast_head);

        //合并链表

        small = head;
        fast = fast_head;
        ListNode tmp_small = null;
        ListNode tmp_fast = null;
        while (small != null && fast != null) {
            tmp_small = small;
            tmp_fast = fast;

            small = small.next;
            fast = fast.next;

            tmp_small.next = tmp_fast;
            tmp_fast.next = small;
        }
    }

    public static void main(String[] args) {
        LintCode099 lintCode099 = new LintCode099();
        //	Input: 1->2->3->4->5->null
        //	Output: 1->5->2->4->3->null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        show(head);
        lintCode099.reorderList(head);
        show(head);
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
