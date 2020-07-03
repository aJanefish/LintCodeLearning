package com.utils;

import com.lintcode.list.BaseCode;

public class ListUtils extends BaseCode {

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
