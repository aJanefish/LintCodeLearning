package com.lintcode100_200;

/**
 * 描述
 * 给一个来自已经排过序的循环链表的节点，写一个函数来将一个值插入到循环链表中，并且保持还是有序循环链表。给出的节点可以是链表中的任意一个单节点。返回插入后的新链表。
 * <p>
 * 3->5->1 是一个循环链表，所以 3 是 1 的下一个节点。3->5->1 与 5->1->3 相同
 * <p>
 * 样例
 * 例1:
 * <p>
 * 输入:
 * 3->5->1
 * 4
 * 输出:
 * 5->1->3->4
 * 例2:
 * <p>
 * 输入:
 * 2->2->2
 * 3
 * 输出:
 * 3->2->2->2
 */
public class LintCode599 extends BaseCode {

    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public static ListNode insert(ListNode head, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }


        ListNode preNode = null;
        ListNode currentNode = head;

        while (true) {
            preNode = currentNode;
            currentNode = currentNode.next;

            //  preNode.val <= x <= currentNode.val
            if (preNode.val < x && x <= currentNode.val) {
                break;
            }


            if (preNode.val > currentNode.val && ((x <= currentNode.val || x >= preNode.val))) {
                break;
            }

            if (currentNode == head) {
                break;
            }
        }

        preNode.next = newNode;
        newNode.next = currentNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = createCycListNode(10, 10, 9, 10);
        show(listNode);
        ListNode ss = insert(listNode, 9);
        show(ss);
    }
}
