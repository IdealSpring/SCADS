package cn.ccut;

import java.util.ArrayList;

/**
 *第二章
 *      -Xms20m  初始堆20M
 *      -Xmx20m  最大20M
 *      -XX:+HeapDumpOnOutOfMemoryError
 *
 *      Java堆溢出:java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {
    public static class OOMObject {
    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
