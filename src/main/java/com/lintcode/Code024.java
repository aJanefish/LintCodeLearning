package com.lintcode;

import com.utils.P;
import com.utils.Test_In_024;

import java.util.List;

/**
 * LFU是一个著名的缓存算法
 * 对于容量为k的缓存，如果缓存已满，并且需要逐出其中的密钥，则最少使用的密钥将被踢出。
 * 实现LFU中的set 和 get
 * <p>
 * 思路：可以用链表或者数组来实现数据存放
 * 不建议用数组。涉及到大量的数据移动，数组没有优势
 * 所以使用链表
 */

class LFUCache {
    /*
     * @param capacity: An integer
     */

    static class Note {
        private int key;
        private int value;
        private int times;
        private Note next;
        private Note pre;

        public Note(int key, int value) {
            this.key = key;
            this.value = value;
            this.times = 0;
        }


        @Override
        public String toString() {
            return "Note{" +
                    "key=" + key +
                    ", value=" + value +
                    ", times=" + times +
                    ", pre=" + ((pre != null) ? "" + pre.key : "null") +
                    ", next=" + ((next != null) ? "" + next.key : "null") +
                    '}';
        }
    }

    private int capacity;
    private Note head;
    private int size = 0;

    public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (head == null) {
            head = new Note(key, value);
            size++;
            return;
        }

        Note note = getNodeByKey(key);
        if (note == null) {//没有找到
            if (size == capacity) {
                removeLRU();
            }
            setHead(new Note(key, value));
            size++;
        } else {
            note.value = value;
        }
    }

    //删除最少被访问的key
    private void removeLRU() {
        size--;
        Note min_Note = head;
        Note tmpNote = min_Note.next;
        while (tmpNote != null) {
            if (tmpNote.times <= min_Note.times) {
                min_Note = tmpNote;
            }
            tmpNote = tmpNote.next;
        }

        if (min_Note == head) {
            head = head.next;
            min_Note.next = null;
            if (head != null) {
                head.pre = null;
            }
        } else {

            Note pre = min_Note.pre;
            if (min_Note.next == null) {
                pre.next = null;
                min_Note.pre = null;
            } else {
                min_Note.next.pre = pre;
                pre.next = min_Note.next;

                min_Note.next = null;
                min_Note.pre = null;
                min_Note = null;
            }
        }
    }

    private void setHead(Note new_Head) {
        if (head == null) {
            head = new_Head;
            return;
        }

        new_Head.pre = null;
        new_Head.next = head;
        head.pre = new_Head;
        head = new_Head;
    }

    private Note getNodeByKey(int key) {
        Note tmpNote = head;
        Note note = null;
        while (tmpNote != null) {
            if (tmpNote.key == key) {
                note = tmpNote;
                note.times += 1;
                break;
            }
            tmpNote = tmpNote.next;
        }

        if (note != null) {
            if (note != head) {
                Note pre = note.pre;
                if (note.next == null) {
                    pre.next = null;
                } else {
                    note.next.pre = pre;
                    pre.next = note.next;
                }
                setHead(note);
            }
        }
        return note;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        Note node = getNodeByKey(key);
        if (node != null) {
            return node.value;
        }
        return -1;
    }

    public StringBuilder show() {
        Note tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=" + size + "\n");
        int i = 0;
        while (tmp != null) {
            stringBuilder.append("" + i + " - " + tmp + "\n");
            tmp = tmp.next;
            i++;
        }

        return stringBuilder;
    }
}

public class Code024 {

    public static void main(String[] args) {
        List<Test_In_024.Code024Data> list = Test_In_024.in();
        int[] label = Test_In_024.label();
        StringBuilder stringBuilder = new StringBuilder("[");
        LFUCache lfuCache = new LFUCache(105);


        int tmp = 0;
        int tmp21 = 0;
        for (int i = 0; i < list.size(); i++) {
            Test_In_024.Code024Data code024Data = list.get(i);
            if (code024Data.getOrSet == Test_In_024.SET) {
                lfuCache.set(code024Data.values1, code024Data.values2);
                String code = "id:" + i + " set(" + code024Data.values1 + "," + code024Data.values2 + ")";
                P.pln(code);
                //Test_In_024.write(i + ".txt", lfuCache.show(), code);

            } else {
                int get = lfuCache.get(code024Data.values1);
                if (get != label[tmp]) {
                    P.pln("id:" + i + " " + tmp + " get(" + code024Data.values1 + ") - " + label[tmp] + " - " + get);
                    //String code = "id:" + i + " " + tmp + " get(" + code024Data.values1 + ") - " + label[tmp] + " - " + get;
                    //Test_In_024.write(i + ".txt", lfuCache.show(), code);
                    break;
                } else {
                    P.pln("id:" + i + " " + tmp + " get(" + code024Data.values1 + ") - " + label[tmp] + " - " + get);
                    // String code = "id:" + i + " " + tmp + " get(" + code024Data.values1 + ") - " + label[tmp] + " - " + get;
                    //Test_In_024.write(i + ".txt", lfuCache.show(), code);
                }
                tmp++;
            }

            if (i == 409) {
                break;
            }
        }

        stringBuilder.append("]");
        P.pln(stringBuilder.toString());
        P.pln(lfuCache.show());
    }
}
