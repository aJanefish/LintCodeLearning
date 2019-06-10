package com.lintcode;
/**
 * 给出一个无重叠的按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 * <p>
 * 输入:
 * (2, 5) into [(1,2), (5,9)]
 * 输出:
 * [(1,9)]
 * <p>
 * 输入:
 * (3, 4) into [(1,2), (5,9)]
 * 输出:
 * [(1,2), (3,4), (5,9)]
 */

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public String toString() {
        return "(" + start +
                "," + end +
                ')';
    }
}

public class LintCode030 {

    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        //P.pln(newInterval);
        List<Interval> new_intervals = new ArrayList<Interval>();


        boolean merge = false;

        for (Interval interval : intervals) {
            if (merge) {
                new_intervals.add(interval);
                continue;
            }
            if (newInterval.end < interval.start) {
                new_intervals.add(newInterval);
                new_intervals.add(interval);
                merge = true;
            } else if (newInterval.start > interval.end) {
                //merge = true;
                new_intervals.add(interval);
                //new_intervals.add(newInterval);
            } else {
                //merge
                int[] ints = {interval.start, interval.end, newInterval.start, newInterval.end};
                Arrays.sort(ints);
                newInterval.start = ints[0];
                newInterval.end = ints[3];

                P.pln(newInterval);
            }
        }

        if (!merge) {
            new_intervals.add(newInterval);
        }
        return new_intervals;
    }

    public static void main(String[] args) {
        LintCode030 lintCode030 = new LintCode030();

        List<Interval> list = new ArrayList<Interval>();
        //[(1,5),(7,8),(10,13)]
        //(6,7)
        list.add(new Interval(1, 5));
        list.add(new Interval(7, 8));
        list.add(new Interval(10, 13));

        Interval interval = new Interval(6, 7);

        List<Interval> list1 = lintCode030.insert(list, interval);
        P.pln(list);
        P.pln(interval);
        P.pln(list1);


    }
}
