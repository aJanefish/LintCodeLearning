package com.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_In_024 {

    public static final int GET = 0;
    public static final int SET = 1;

    public static int[] label() {
        int[] ins = {-1, -1, -1, -1, -1, 280, -1, -1, 261, -1, -1, -1, -1, -1, 38, -1, -1, -1, 148, -1, -1, -1, -1, -1, -1, -1, -1, 136, -1, -1, -1, -1, -1, 153, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 160, 51, -1, 218, -1, 261, -1, -1, -1, 193, -1, -1, 220, -1, -1, -1, -1, 306, 219, -1, -1, 266, 193, 90, -1, -1, 147, -1, 148, 147, 131, -1, 291, 291, -1, 178, -1, 136, -1, 147, -1, 287, -1, -1, -1, 183, 174, 110, -1, -1, -1, 12, -1, 89, 305, 70, -1, 94, -1, -1, 241, 176, 220, -1, 306, -1, 183, -1, 12, -1, 95, -1, -1, 311, 111, 190, 84, -1, -1, 177, 157, -1, -1, 174, 51, 183, -1, 4, -1, -1, 21, 51, 176, 89, -1, -1, 176, 313, 86, 229, 176, 294, 110, 101, 128, 49, 82, 193, 193, -1, 85, 101, 126, 66, -1, -1, -1, 67, 66, 126, 101, 84, 184, 23, 198, 110, 101, 130, 131, 130, 239, 35, -1, 287, -1, 240, 313, 67, 236, 121, 239, 299, 101, 105, 118, 160, 135, 255, -1, 11, 101, 258, -1, 35, 88, 160, 11, 276, 291, 299, 90, 75, 291, 276, 118, -1, 121, 252, 145, 191, -1, 75, -1, 23, 139, -1, 177, 165, 311, 184, 309, 100, 151, 109, -1, 90, 136, 299, 173, 173, -1, -1, 313, 45, 252, -1, 212, 132, -1, 137, 308, 15, -1, -1, 288, -1, 2, 22, -1, 299, 137, 295, 139, 13, 101, -1, 249, 190, -1, 136, -1, 151, 203, 90, 88, 190, 160, 40, 24, 132, 30, 236, -1, 67, 119, -1, 24, 132, 1, -1, 236, 236, -1, 15, 183, 311, 295, 183, -1, 188, 47, 311, 53, 25};
        P.pln(ins.length);
        return ins;
    }


    public static List<Code024Data> in() {
        File file = new File("Code024.in");
        List<Code024Data> list = new ArrayList();
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file), "GBK");
            BufferedReader bfreader = new BufferedReader(reader);
            String line;
            while ((line = bfreader.readLine()) != null) {//包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
                //System.out.println(line);
                if (line.startsWith("get")) {
                    line = line.substring(4, line.length() - 1);
                    list.add(new Code024Data(GET, Integer.parseInt(line), 0));
                } else {
                    line = line.substring(4, line.length() - 1);
                    String[] ss = line.split(", ");
                    list.add(new Code024Data(SET, Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
                }

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        P.pln(list);
        return list;
    }

    public static void write(String name, StringBuilder stringBuilder, String code) {
        int number = 1;
        OutputStream os = null;
        try {
            os = new FileOutputStream("024/" + name);
            PrintWriter pw = new PrintWriter(os);

            pw.println(code);//每输入一个数据，自动换行，便于我们每一行每一行地进行读取
            pw.println(stringBuilder.toString());
            pw.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class Code024Data {
        public int getOrSet;
        public int values1;
        public int values2;

        public Code024Data(int getOrSet, int values1, int values2) {
            this.getOrSet = getOrSet;
            this.values1 = values1;
            this.values2 = values2;
        }

        @Override
        public String toString() {
            return "Code024Data{" +
                    "getOrSet=" + ((getOrSet == GET) ? "GET" : "SET") +
                    ", values1=" + values1 +
                    ", values2=" + values2 +
                    '}';
        }
    }
}
