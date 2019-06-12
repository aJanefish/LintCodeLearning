package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
 * <p>
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * <p>
 * pop和top方法都应该返回第一个元素的值。
 */

public class LintCode040 {
    Stack in = new Stack();
    Stack out = new Stack();

    static class Stack {
        List<Integer> stack = new ArrayList<Integer>();

        void push(Integer integer) {
            stack.add(integer);
        }

        Integer pop() {
            if (stack.size() == 0)
                return -1;
            return stack.remove(0);
        }

        int top() {
            if (stack.size() == 0)
                return -1;
            return stack.get(0);
        }
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        int o = out.pop();
        while (o != -1) {
            in.push(o);
            o = out.pop();
        }
        in.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int i = in.pop();
        while (i != -1) {
            out.push(i);
            i = in.pop();
        }

        return out.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int i = in.pop();
        while (i != -1) {
            out.push(i);
            i = in.pop();
        }
        return out.top();
    }

    public static void main(String[] args) {
        LintCode040 lintCode040 = new LintCode040();
        lintCode040.push(1);
        P.pln(lintCode040.pop());
        lintCode040.push(2);
        lintCode040.push(3);
        P.pln(lintCode040.top());
        P.pln(lintCode040.pop());
    }
}
