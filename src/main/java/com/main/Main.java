package com.main;

import com.utils.P;
import com.utils.RandomUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        int m = 900;
        int n = 450;
        test1(m, n);
        test2(m, n);
    }

    private static void test2(int m, int n) {
        P.pln("test2-------------------------");
        long start = System.nanoTime();
        List<Integer> list = RandomUtils.version_two(m, n);
        long end = System.nanoTime();
        P.pln(list.size());
        //P.pln(list);
        P.pln("total time:" + ((float)(end - start)/(float)1e9));
    }

    private static void test1(int m, int n) {
        P.pln("test1-------------------------");

        long start = System.nanoTime();
        List<Integer> list = RandomUtils.version_one(m, n);
        long end = System.nanoTime();
        P.pln(list.size());
        //P.pln(list);
        P.pln("total time:" + ((float)(end - start)/(float)1e9));
    }


}
