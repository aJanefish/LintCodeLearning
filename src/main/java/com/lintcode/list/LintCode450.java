package com.lintcode.list;

import com.lintcode.list.BaseCode;

/**
 * 描述
 * 给你一个链表以及一个k,将这个链表从头指针开始每k个翻转一下。
 * 链表元素个数不是k的倍数，最后剩余的不用翻转。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * Example 1
 * <p>
 * Input:
 * list = 1->2->3->4->5->null
 * k = 2
 * Output:
 * 2->1->4->3->5
 * Example 2
 * <p>
 * Input:
 * list = 1->2->3->4->5->null
 * k = 3
 * Output:
 * 3->2->1->4->5
 */
public class LintCode450 extends BaseCode {

    /**
     * @param head: a ListNode
     * @param k:    An integer
     * @return: a ListNode
     */
    //100% 数据通过测试总耗时 239 ms
    //您的提交打败了 84.20% 的提交!
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode tmpNode;
        ListNode tmpHead = null;
        ListNode tmpTail = null;

        ListNode newHead = null;
        ListNode newTail = null;
        //头插法
        int sum = 0;
        while (head != null) {
            tmpNode = head;
            head = head.next;

            if (tmpHead == null) {
                tmpHead = tmpNode;
                tmpTail = tmpNode;
                tmpTail.next = null;
            } else {
                tmpNode.next = tmpHead;
                tmpHead = tmpNode;
            }

            sum++;
            if (sum == k) {
                sum = 0;
                //小循环结束
                if (newHead == null) {
                    newHead = tmpHead;
                    newTail = tmpTail;
                } else {
                    newTail.next = tmpHead;
                    newTail = tmpTail;
                }
                tmpTail.next = null;
                tmpHead = null;
                tmpTail = null;
            }
        }

        System.out.println(sum);
        if (sum != 0) {
            ListNode tHead = null;
            ListNode tTail = null;
            //System.out.println("tmpHead " + tmpHead.val);
            //System.out.println("tmpTail " + tmpTail.val);
            while (tmpHead != null) {
                tmpNode = tmpHead;
                tmpHead = tmpHead.next;
                if (tHead == null) {
                    tHead = tmpNode;
                    tTail = tmpNode;
                    tTail.next = null;
                    tHead.next = null;
                } else {
                    tmpNode.next = tHead;
                    tHead = tmpNode;
                }
            }

            if (newHead == null) {
                newHead = tHead;
            } else {
                newTail.next = tHead;
            }

        }


        return newHead;
    }

    public static void main(String[] args) {
        ListNode ss = createListNode(1, 2, 3, 4, 5);
        show(ss);

        ListNode ss1 = reverseKGroup(ss, 6);
        show(ss1);
    }
}
