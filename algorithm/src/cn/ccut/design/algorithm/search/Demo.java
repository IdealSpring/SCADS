package cn.ccut.design.algorithm.search;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 16; i++) {
            map.put(i, i);
            System.out.println("第 " + i + "次循环");
        }

    }
}
