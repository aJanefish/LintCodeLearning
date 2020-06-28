package com.lintcode100_200;

import java.util.HashMap;
import java.util.Map;

public class LintCode105 {

    //Definition for singly-linked list with a random pointer.
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "label=" + label +
                    ", next=" + ((next != null) ? "" + next.label : "null") +
                    ", random=" + ((random != null) ? "" + random.label : "null") +
                    '}';
        }
    }


    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    //100% 数据通过测试总耗时 2027 ms
    //您的提交打败了 69.80% 的提交!
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        RandomListNode newHead = null;
        RandomListNode newCurrent = null;
        RandomListNode oldCurrent = head;

        Map<RandomListNode, Integer> map = new HashMap<RandomListNode, Integer>();
        Map<Integer, RandomListNode> maps = new HashMap<Integer, RandomListNode>();

        while (oldCurrent != null) {
            if (newHead == null) {
                newHead = new RandomListNode(oldCurrent.label);
                newCurrent = newHead;
            } else {
                newCurrent.next = new RandomListNode(oldCurrent.label);
                newCurrent = newCurrent.next;
            }
            if (oldCurrent.random != null) {
                map.put(newCurrent, oldCurrent.random.label);
            }
            maps.put(newCurrent.label, newCurrent);
            oldCurrent = oldCurrent.next;
        }

        newCurrent = newHead;
        while (newCurrent != null) {
            newCurrent.random = maps.get(map.get(newCurrent));
            newCurrent = newCurrent.next;
        }

        return newHead;
    }


    public static void main(String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;

        randomListNode1.random = randomListNode1;
        randomListNode2.random = randomListNode2;
        randomListNode3.random = randomListNode3;
        randomListNode4.random = randomListNode4;

        LintCode105 lintCode105 = new LintCode105();
        RandomListNode copyRandomList = lintCode105.copyRandomList(randomListNode1);
        show(randomListNode1);
        System.out.println("---------------------------");
        show(copyRandomList);
    }

    private static void show(RandomListNode randomListNode) {
        while (randomListNode != null) {
            System.out.println(randomListNode);
            randomListNode = randomListNode.next;
        }
    }
}
