package com.lintcode.list;

/**
 * 描述
 * 将两个排序链表合并为一个新的排序链表
 * <p>
 * 样例
 * 样例 1:
 * 输入: list1 = null, list2 = 0->3->3->null
 * 输出: 0->3->3->null
 * <p>
 * <p>
 * 样例2:
 * 输入:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * 输出: 1->2->3->8->11->15->null
 */
public class LintCode165 extends BaseCode {

    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode newHead = null;
        ListNode newTail = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (newHead == null) {
                    newHead = l1;
                    newTail = l1;
                } else {
                    newTail.next = l1;
                    newTail = newTail.next;
                }
                l1 = l1.next;
            } else {
                if (newHead == null) {
                    newHead = l2;
                    newTail = l2;
                } else {
                    newTail.next = l2;
                    newTail = newTail.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {

            if (newTail != null) {
                newTail.next = l1;
            } else {
                newHead = l1;
            }

        } else {
            if (newTail != null) {
                newTail.next = l2;
            } else {
                newHead = l2;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode();
        ListNode listNode1 = createListNode(1, 2, 3, 4, 5);
        show(listNode);
        show(listNode1);
        ListNode listNode2 = mergeTwoLists(listNode1, listNode);
        show(listNode2);
    }
}
