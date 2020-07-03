package com.lintcode.list;

/**
 * 描述
 * 请写一个程序，找到两个单链表最开始的交叉节点
 */
public class LintCode380 extends BaseCode {

    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        ListNode newHeadA = reverseList(headA);
        ListNode newHeadB = reverseList(headB);


        ListNode curA = newHeadA;
        ListNode curB = newHeadB;

        ListNode result = null;
        while (curA != null && curB != null) {
            if (curA.val != curB.val) {
                result = curA;
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }



        headA = reverseList(newHeadA);
        headB = reverseList(newHeadB);

        if (result == null){
            if (curA != null && curB == null) {
                result = headB;
            } else if (curA == null && curB != null) {
                result = headA;
            } else if (curA == null && curB == null) {

            } else {

            }
        }

        if (result == null){
            return null;
        }

        return result;
    }

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

    public static void main(String[] args) {
        ListNode listNode = createListNode(7, 8, 9, 10, 11, 12, 13);
        ListNode listNode1 = createListNode(1, 2, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        ListNode ss = getIntersectionNode(listNode, listNode1);
        show(listNode);
        show(listNode1);
        show(ss);
    }
}
