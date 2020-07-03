package com.lintcode.list;

/**
 * 描述
 * 给定单链表，将所有奇数节点连接在一起，然后将偶数节点连接在一起。 请注意，这里我们讨论的是节点编号，而不是节点中的值。
 * <p>
 * 奇数节点和偶数节点的相对位置应当不变。
 * 第一个节点应为奇数，第二个节点为偶数，以此类推……
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例1:
 * <p>
 * 输入： 1->2->3->4->5->NULL
 * 输出： 1->3->5->2->4->NULL
 * 样例2:
 * <p>
 * 输入： 2->1->null
 * 输出： 2->1->null
 */
public class LintCode1292 extends BaseCode {

    /**
     * @param head: a singly linked list
     * @return: Modified linked list
     */
    //100% 数据通过测试总耗时 453 ms
    //您的提交打败了 66.40% 的提交!
    public static ListNode oddEvenList(ListNode head) {
        // write your code here

        ListNode jiHead = null;
        ListNode jiTail = null;
        ListNode ouHead = null;
        ListNode ouTail = null;

        int index = 0;
        while (head != null) {
            index++;
            if (index % 2 == 1) {
                //奇数
                if (jiHead == null) {
                    jiHead = head;
                    jiTail = head;
                } else {
                    jiTail.next = head;
                    jiTail = jiTail.next;
                }
            } else {
                //偶数

                //奇数
                if (ouHead == null) {
                    ouHead = head;
                    ouTail = head;
                } else {
                    ouTail.next = head;
                    ouTail = ouTail.next;
                }
            }

            head = head.next;
        }

        if (jiTail != null) {
            jiTail.next = ouHead;
        }
        if (ouTail != null) {
            ouTail.next = null;
        }
        return jiHead;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(1, 2,3);
        show(listNode);
        ListNode ss = oddEvenList(listNode);
        show(ss);
    }
}
