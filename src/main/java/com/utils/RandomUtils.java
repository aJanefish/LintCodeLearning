package com.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 随机工具类
 */
public class RandomUtils {
    private static Random random = new Random();

    // m >= n
    public static List<Integer> version_one(int m, int n) {
        //[0,m-1]
        List<Integer> list = new ArrayList<Integer>();
        int tmp = 0;
        int nums = 0;
        for (int i = 0; i < n; i++) {
            tmp = random.nextInt(m);
            nums++;
            while (list.contains(tmp)) {
                tmp = random.nextInt(m);
                nums++;
            }
            list.add(tmp);
        }
        P.pln("nums:" + nums + " - " + ((float) nums / (float) n));
        return list;
    }

    // m >= n
    public static List<Integer> version_two(int m, int n) {
        //[0,m-1]
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> new_list = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            list.add(i);
        }

        int tmp = 0;
        int nums = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            index = random.nextInt(list.size());
            tmp = list.get(index);
            nums++;
            while (new_list.contains(tmp)) {
                index = random.nextInt(list.size());
                tmp = list.get(index);
                nums++;
            }
            new_list.add(list.remove(index));
        }
        P.pln("nums:" + nums + " - " + ((float) nums / (float) n));
        return new_list;
    }
}
