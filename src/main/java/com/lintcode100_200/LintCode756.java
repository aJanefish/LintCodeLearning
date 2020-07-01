package com.lintcode100_200;


/**
 * 描述
 * 给出两个链表形式表示的数字,写一个函数得到这两个链表相乘乘积。
 * 样例
 * 样例 1:
 * <p>
 * 输入：9->4->6->null,8->4->null
 * 输出：79464
 * 解释：946*84=79464
 * 样例 2:
 * <p>
 * 输入：3->2->1->null,1->2->null
 * 输出：3852
 * 解释：321*12=3852
 */
public class LintCode756 extends BaseCode {

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the product list of l1 and l2
     */
    //100% 数据通过测试总耗时 153 ms
    //您的提交打败了 96.30% 的提交!a
    public static long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here

        return getValues(l1) * getValues(l2);
    }

    private static long getValues(ListNode head) {
        if (head == null) {
            return 0;
        }

        long sum = 0;
        long b = 10;
        while (head != null) {

            sum = sum * b + head.val;
            head = head.next;
            System.out.println(sum + " " + b);
        }

        return sum;
    }


    public static void main(String[] args) {
        ListNode listNode = createListNode(1, 2, 3, 4, 5);
        ListNode listNode1 = createListNode(1, 2, 3, 4, 5);
        show(listNode);
        show(listNode1);
        System.out.println(getValues(listNode));
        //System.out.println(getValues(listNode1));
        System.out.println(multiplyLists(listNode, listNode1));
    }
}
