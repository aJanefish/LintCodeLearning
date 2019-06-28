package com.lintcode;

import com.utils.P;

/**
 * 给定一个链表，判断它是否有环
 */
public class LintCode102 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     *
     * 您的提交打败了 93.40% 的提交!
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null) return false;
        if (head.next == null) return false;

        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != null && quick != null) {
            if (slow == quick) {
                return true;
            }

            if (quick.next == null) {
                return false;
            } else {
                if (quick.next.next == null) {
                    return false;
                }
                slow = slow.next;
                quick = quick.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LintCode102 lintCode102 = new LintCode102();
        //21->10->4->5->null
        ListNode listNode = new ListNode(21);
        listNode.next = new ListNode(10);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = listNode;
        boolean ss = lintCode102.hasCycle(listNode);
        P.pln(ss);
    }

}
