package com.lintcode.list;

/**
 * 描述
 * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
 * <p>
 * 你需要交换两个节点而不是仅仅交换节点的权值
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: 1->2->3->4->null, v1 = 2, v2 = 4
 * 输出: 1->4->3->2->null
 * 样例 2:
 * <p>
 * 输入: 1->null, v1 = 2, v2 = 1
 * 输出: 1->null
 */
public class LintCode511 extends BaseCode {


    /**
     * @param head: a ListNode
     * @param v1:   An integer
     * @param v2:   An integer
     * @return: a new head of singly-linked list
     */
    //100% 数据通过测试总耗时 193 ms
    //您的提交打败了 87.60% 的提交!
    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        ListNode v1Node = null;
        ListNode v2Node = null;

        ListNode tmpCurrent = head;
        while (tmpCurrent != null) {
            if (tmpCurrent.val == v1) {
                v1Node = tmpCurrent;
            }

            if (tmpCurrent.val == v2) {
                v2Node = tmpCurrent;
            }

            if (v1Node != null && v2Node != null) {
                v1Node.val = v2;
                v2Node.val = v1;
                break;
            }
            tmpCurrent = tmpCurrent.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(1, 2, 3, 4, 5);
        show(listNode);
        ListNode ss = swapNodes(listNode, 2, 4);
        show(ss);
    }
}
