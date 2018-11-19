package cn.ccut.design.algorithm.other;

import java.util.TreeMap;

public class SCRDemo {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap1 = new TreeMap<>();
        treeMap1.put(10, 10);
        treeMap1.put(5, 5);
        treeMap1.put(15, 15);
        treeMap1.put(2, 2);
        treeMap1.put(6, 6);
        treeMap1.put(13, 13);
        treeMap1.put(16, 16);

        treeMap1.remove(10);
    }
}
