package com.lintcode.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 描述
 * 我们需要实现一个叫 DataStream 的数据结构。并且这里有 两 个方法需要实现：
 * <p>
 * void add(number) // 加一个新的数
 * int firstUnique() // 返回第一个独特的数
 * 你可以假设在调用 firstUnique 方法时，数据流中至少有一个独特的数字
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 例1:
 * <p>
 * 输入:
 * add(1)
 * add(2)
 * firstUnique()
 * add(1)
 * firstUnique()
 * 输出:
 * [1,2]
 * 例2:
 * <p>
 * 输入:
 * add(1)
 * add(2)
 * add(3)
 * add(4)
 * add(5)
 * firstUnique()
 * add(1)
 * firstUnique()
 * add(2)
 * firstUnique()
 * add(3)
 * firstUnique()
 * add(4)
 * firstUnique()
 * add(5)
 * add(6)
 * firstUnique()
 * 输出:
 * [1,2,3,4,5,6]
 */
public class LintCode960 extends BaseCode {

    public static class DataStream {

        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();

        public DataStream() {
            // do intialization if necessary
        }

        /**
         * @param num: next number in stream
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            if (!hashSet.contains(num)) {//就是唯一
                hashSet.add(num);
                list.add(num);
            }else {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()){
                    if(iterator.next()== num){
                        iterator.remove();
                        return;
                    }
                }
            }
        }

        /**
         * @return: the first unique number in stream
         */
        public int firstUnique() {
            // write your code here
            System.out.println(hashSet);
            System.out.println(list);
            return list.get(0);
        }
    }

    public static void main(String[] args) {

        DataStream dataStream = new DataStream();
        dataStream.add(1);
        dataStream.add(2);
        System.out.println(dataStream.firstUnique());
        dataStream.add(1);
        System.out.println(dataStream.firstUnique());

    }
}
