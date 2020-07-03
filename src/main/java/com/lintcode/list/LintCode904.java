package com.lintcode.list;

import com.utils.ListUtils;

/**
 * 加一链表
 */
public class LintCode904 extends BaseCode {


    public static void main(String[] args) {

        ListNode ss = createListNode(9,9,9,9,9);
        show(ss);

        ListNode ss1 = plusOne(ss);
        show(ss1);
    }
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public static ListNode plusOne(ListNode head) {
        // Write your code here


        if (head == null) {
            return null;
        }

        head = reverseList(head);

        int lastFlag = 1;
        ListNode newHead = null;
        ListNode tmpNode = null;

        //头插法
        while (head != null) {
            tmpNode = head;
            head = head.next;
            int curValue = (tmpNode.val + lastFlag) % 10;
            lastFlag = (tmpNode.val + lastFlag) / 10;

            tmpNode.val = curValue;

            tmpNode.next = newHead;
            newHead = tmpNode;
        }

        if (lastFlag == 1){
            ListNode node = new ListNode(1);
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    //翻转链表
    public static ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode tmpNode = null;
        while (head != null) {
            tmpNode = head;
            head = head.next;
            tmpNode.next = newList;
            newList = tmpNode;
        }
        return newList;
    }
}
