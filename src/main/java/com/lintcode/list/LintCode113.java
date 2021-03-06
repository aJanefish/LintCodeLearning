package com.lintcode.list;

/**
 * 描述
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1
 * <p>
 * 输入 : 1->2->3->3->4->4->5->null
 * 输出 : 1->2->5->null
 * 样例 2
 * <p>
 * 输入 : 1->1->1->2->3->null
 * 输出 : 2->3->null
 */
public class LintCode113 {


    //Definition for ListNode
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode pre = null;
        ListNode current = null;
        ListNode next = head;
        ListNode newHead = null;
        while (next != null) {
            if (pre == null) {
                if (current == null) {
                    current = next;
                } else {
                    if (current.val == next.val) {

                    } else {
                        if (current.next == next) {
                            //不删除
                            pre = current;
                            newHead = pre;
                            current = next;
                        } else {
                            current = next;
                        }
                    }
                }
            } else {
                if (current.val == next.val) {

                } else {
                    if (current.next == next) {
                        pre = current;
                        current = next;
                    } else {
                        pre.next = next;
                        current = next;
                    }

                }
            }

            next = next.next;
        }

        if (pre == null) {
            if (current == null) {
                current = next;
            } else {
                if (current.next == next) {
                    //不删除
                    pre = current;
                    newHead = pre;
                }
            }
        } else {
            if (current.next != next) {
                pre.next = next;
            }
        }


        return newHead;
    }

    public static void main(String[] args) {
        //ListNode listNode = createListNode(1, 2, 3, 4, 5, 6, 6, 7);
        //ListNode listNode = createListNode(1, 2, 3, 4, 5, 6, 6, 7,7);
        ListNode listNode = createListNode(1, 1, 1);
        show(listNode);
        LintCode113 lintCode113 = new LintCode113();
        ListNode ss = lintCode113.deleteDuplicates(listNode);
        show(ss);
    }

    private static void show(ListNode listNode) {
        while (listNode != null) {
            System.out.print("" + listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }


    private static ListNode createListNode(int... values) {
        ListNode headNode = new ListNode(values[0]);
        ListNode current = headNode;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return headNode;
    }
}
