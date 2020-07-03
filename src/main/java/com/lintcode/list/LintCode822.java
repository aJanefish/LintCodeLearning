package com.lintcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给出一个链表，并将链表的值以倒序存储到数组中。
 * <p>
 * 您不能改变原始链表的结构。
 * ListNode 有两个成员变量：ListNode.val 和 ListNode.next
 * 样例
 * 样例1
 * <p>
 * 输入: 1 -> 2 -> 3 -> null
 * 输出: [3,2,1]
 * 样例2
 * <p>
 * 输入: 4 -> 2 -> 1 -> null
 * 输出: [1,2,4]
 */
public class LintCode822 extends BaseCode {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public static List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {

            list.add(0, head.val);
            head = head.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(1, 2, 3, 4, 5, 6, 7);
        List<Integer> ss = reverseStore(listNode);
        show(listNode);
        System.out.println(ss);
    }
}
