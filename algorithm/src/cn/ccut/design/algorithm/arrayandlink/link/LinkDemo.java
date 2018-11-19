package cn.ccut.design.algorithm.arrayandlink.link;

import org.junit.Test;

import java.util.Iterator;

public class LinkDemo {
    @Test
    public void test() {
        MyLinkedList<String> link = new MyLinkedList<>();
        link.add("hello");
        link.add("world");
        link.add("java");

        System.out.println(link.get(0));
        System.out.println(link.get(1));

        /*Iterator<String> it = link.iterator(0);
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/

        for (String s12 : link) {

        }

    }
}
