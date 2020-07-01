package com.lintcode100_200;

/**
 * 描述
 * 实现一个队列的操作
 * <p>
 * enqueue(item).将新元素放入队列中。
 * dequeue(). 将第一个元素移出队列，返回它。
 * 样例
 * 例1:
 * <p>
 * 输入：
 * enqueue(1)
 * enqueue(2)
 * enqueue(3)
 * dequeue() // return 1
 * enqueue(4)
 * dequeue() // return 2
 * 例2:
 * <p>
 * 输入：
 * enqueue(10)
 * dequeue()// return 10
 */
public class LintCode492 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        // write your code here
        ListNode listNode = new ListNode(item);
        if (tail == null) {
            head = listNode;
            tail = listNode;
        } else {
            tail.next = listNode;
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head == null) {
            return 0;
        }
        int value = head.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        return value;
    }

    public static void main(String[] args) {
        LintCode492 lintCode492 = new LintCode492();
        lintCode492.enqueue(438);
        System.out.print(lintCode492.dequeue());
        lintCode492.enqueue(452);
        lintCode492.enqueue(379);
        lintCode492.enqueue(884);
        lintCode492.enqueue(332);
        lintCode492.enqueue(55);
        System.out.print(lintCode492.dequeue());
        lintCode492.enqueue(825);
        System.out.print(lintCode492.dequeue());
        System.out.print(lintCode492.dequeue());
        System.out.print(lintCode492.dequeue());
        System.out.print(lintCode492.dequeue());
        lintCode492.enqueue(983);
        System.out.print(lintCode492.dequeue());
        System.out.print(lintCode492.dequeue());
        lintCode492.enqueue(616);
        lintCode492.enqueue(66);
    }
}
