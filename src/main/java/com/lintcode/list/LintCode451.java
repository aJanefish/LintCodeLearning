package com.lintcode.list;

import com.lintcode.list.BaseCode;

/**
 * 描述
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 * <p>
 * 样例
 * 样例 1：
 * <p>
 * 输入：1->2->3->4->null
 * 输出：2->1->4->3->null
 * 样例 2：
 * <p>
 * 输入：5->null
 * 输出：5->null
 * <p>
 * 挑战
 * 你的算法只能使用常数的额外空间，并且不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LintCode451 extends BaseCode {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    //100% 数据通过测试总耗时 236 ms
    //您的提交打败了 85.00% 的提交!
    public static ListNode swapPairs(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        ListNode tmp = null;

        while (cur != null && cur.next != null) {

            cur = cur.next.next;
            if (pre == null) {
                tmp = head.next;
                head.next = cur;
                tmp.next = head;

                head = tmp;

                pre = head.next;

            } else {
                tmp = pre.next.next;
                pre.next.next = cur;

                tmp.next = pre.next;

                pre.next = tmp;

                pre = pre.next.next;

            }

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode ss = createListNode(1, 2, 3, 4, 5);
        show(ss);

        ListNode ss1 = swapPairs(ss);
        show(ss1);
    }
}
