package com.lintcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * 输入:   [2->4->null,null,-1->null]
 * 输出:  -1->2->4->null
 * <p>
 * 样例 2:
 * 输入: [2->6->null,5->null,7->null]
 * 输出:  2->5->6->7->null
 */
public class LintCode104 {


    //Definition for ListNode.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        //第二种算法  两两合并的变化
        ListNode finalListNode = null;
        List<ListNode> tmpList = lists;
        while (tmpList.size() != 1) {

            //1,2 3, 4  -- n-2 ，n-1
            List<ListNode> currentList = new ArrayList<ListNode>();
            for (int i = 0; i < tmpList.size(); i += 2) {
                ListNode tmp1 = lists.get(i);
                ListNode tmp2 = null;
                if (i + 1 < lists.size()) {
                    tmp2 = lists.get(i + 1);
                }

                //两个两个合为一个
                finalListNode = merge(tmp1, tmp2);

                currentList.add(finalListNode);
            }
            tmpList.clear();
            tmpList.addAll(currentList);
        }
        return tmpList.get(0);
    }


    //第一种算法 两两合并
    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode resultListNode = null;
        ListNode currentListNode = null;
        while (listNode1 != null || listNode2 != null) {

            if (listNode1 != null && listNode2 == null) {
                if (resultListNode == null) {
                    resultListNode = listNode1;
                    currentListNode = resultListNode;
                } else {
                    currentListNode.next = listNode1;
                    currentListNode = currentListNode.next;
                }
                listNode1 = listNode1.next;
            } else if (listNode1 == null && listNode2 != null) {
                if (resultListNode == null) {
                    resultListNode = listNode2;
                    currentListNode = resultListNode;
                } else {
                    currentListNode.next = listNode2;
                    currentListNode = currentListNode.next;
                }
                listNode2 = listNode2.next;
            } else {
                if (listNode1.val < listNode2.val) {
                    if (resultListNode == null) {
                        resultListNode = listNode1;
                        currentListNode = resultListNode;
                    } else {
                        currentListNode.next = listNode1;
                        currentListNode = currentListNode.next;
                    }
                    listNode1 = listNode1.next;
                } else {
                    if (resultListNode == null) {
                        resultListNode = listNode2;
                        currentListNode = resultListNode;
                    } else {
                        currentListNode.next = listNode2;
                        currentListNode = currentListNode.next;
                    }
                    listNode2 = listNode2.next;
                }
            }
        }
        return resultListNode;
    }


    public static void main(String[] args) {
        ListNode listNode1 = createListNode(1, 4, 7);
        ListNode listNode2 = createListNode(2, 5, 8);
        ListNode listNode3 = createListNode(3, 6, 9);
        show(listNode1);
        show(listNode2);
        show(listNode3);

        List<ListNode> listNodes = new ArrayList<ListNode>();
        listNodes.add(listNode1);
        listNodes.add(listNode2);
        listNodes.add(listNode3);

        LintCode104 lintCode104 = new LintCode104();
        ListNode ss = lintCode104.mergeKLists(listNodes);
        show(ss);

//        ListNode ss1 = lintCode104.merge(listNode1, listNode1);
//        show(ss1);
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
