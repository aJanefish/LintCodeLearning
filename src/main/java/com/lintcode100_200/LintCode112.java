package com.lintcode100_200;

public class LintCode112 {


    //Definition for ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    //-14->-14->-13->-13->-13->-13->-12->-12->-11->-10->-9->-9->-9->-9->-9->-9->-9->-9->-8->-8->-8->-7->-7->-7->-4->-4->-4->-4->-2->-1->-1->-1->-1->-1->-1->0->0->1->1->2->2->2->2->2->3->3->4->5->5->5->5->5->5->6->6->6->7->7->7->7->7->8->8->9->9->10->10->10->10->11->11->12->13->14->14->14->15->15->15->16->17->17->17->17->17->17->18->18->19->19->19->20->20->20->20->20->21->22->22->23->23->23->23->
    // 24->25->25->25->25->25->null
    //100% 数据通过测试总耗时 402 ms
    //您的提交打败了 88.00% 的提交!
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode current = head;
        int lastValue = 0;
        ListNode startNode = null;

        while (current != null) {
            if (startNode == null) {
                startNode = current;
                lastValue = current.val;
            } else {
                if (lastValue == current.val) {
                    startNode.next = current.next;
                } else {
                    startNode = current;
                    lastValue = current.val;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = createListNode(1, 2, 3, 3, 4, 4, 5, 6, 6, 7);
        show(listNode);
        LintCode112 lintCode112 = new LintCode112();
        ListNode listNode1 = lintCode112.deleteDuplicates(listNode);
        show(listNode1);
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
