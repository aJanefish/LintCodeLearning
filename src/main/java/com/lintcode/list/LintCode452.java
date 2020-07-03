package com.lintcode.list;

/**
 * 描述
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1：
 * <p>
 * 输入：head = 1->2->3->3->4->5->3->null, val = 3
 * 输出：1->2->4->5->null
 * 样例 2：
 * <p>
 * 输入：head = 1->1->null, val = 1
 * 输出：null
 */
public class LintCode452 extends BaseCode {

    /**
     * @param head: a ListNode
     * @param val:  An integer
     * @return: a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {

            if (cur.val != val) {
                pre = cur;
                cur = cur.next;
            } else {
                if (pre == null) {
                    //head 后移
                    head = cur.next;
                    cur = cur.next;
                } else {
                    //删除当前节点
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(2, 2, 2, 4, 5);
        show(listNode);
        ListNode ss = removeElements(listNode, 2);
        show(ss);
    }
}
