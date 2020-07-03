package com.lintcode.list;

public class BaseCode {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    protected static void show(ListNode head) {
        ListNode listNode = head;
        while (listNode != null) {
            System.out.print("" + listNode.val + ", ");
            if (listNode.next == head) {
                break;
            }
            listNode = listNode.next;
        }
        System.out.println();
    }

    protected static ListNode createListNode(int... values) {
        if (values.length == 0) {
            return null;
        }
        ListNode headNode = new ListNode(values[0]);
        ListNode current = headNode;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return headNode;
    }

    protected static ListNode createCycListNode(int... values) {
        ListNode headNode = new ListNode(values[0]);
        ListNode current = headNode;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        current.next = headNode;
        return headNode;
    }
}
