package com.lintcode100_200;

/**
 * 描述
 * 假定用链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: 6->1->7   2->9->5
 * 输出: 9->1->2
 * 样例 2:
 * <p>
 * 输入: 1->2->3   4->5->6
 * 输出: 5->7->9
 */
public class LintCode221 extends BaseCode {

    /**
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public static ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here

        //链表反转
        ListNode l11 = reverseList(l1);
        ListNode l22 = reverseList(l2);


        //求和，
        int nextValue = 0;
        ListNode newListHead = null;
        ListNode currentL1 = null;
        ListNode currentL2 = null;
        while (l11 != null && l22 != null) {
            currentL1 = l11;
            currentL2 = l22;

            l11 = l11.next;
            l22 = l22.next;


            int currentValue = (currentL1.val + currentL2.val + nextValue) % 10;
            nextValue = (currentL1.val + currentL2.val + nextValue) / 10;

            // 构造节点
            currentL1.val = currentValue;
            currentL1.next = newListHead;

            newListHead = currentL1;
        }

        if (l22 != null) {

            while (l22 != null) {
                currentL2 = l22;
                l22 = l22.next;

                int currentValue = (currentL2.val + nextValue) % 10;
                nextValue = (currentL2.val + nextValue) / 10;
                currentL2.val = currentValue;

                currentL2.next = newListHead;
                newListHead = currentL2;
            }
        } else {
            while (l11 != null) {
                currentL1 = l11;
                l11 = l11.next;


                int currentValue = (currentL1.val + nextValue) % 10;
                nextValue = (currentL1.val + nextValue) / 10;
                currentL1.val = currentValue;

                currentL1.next = newListHead;
                newListHead = currentL1;
            }
        }

        if (nextValue == 1) {
            ListNode listNode = new ListNode(1);
            listNode.next = newListHead;
            newListHead = listNode;
        }

        return newListHead;
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
        System.out.println(617 + 295);
        ListNode listNode = createListNode(6, 1, 7);
        ListNode listNode1 = createListNode(2, 9, 5);
        show(listNode);
        show(listNode1);

        ListNode ss = addLists2(listNode, listNode1);
        show(ss);
    }
}
