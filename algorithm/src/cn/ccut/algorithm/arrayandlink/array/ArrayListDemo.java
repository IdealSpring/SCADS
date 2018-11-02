package cn.ccut.algorithm.arrayandlink.array;

import org.junit.Test;

public class ArrayListDemo {
    public void test(Str str) {
        String ss = str.s;
    }

    private static class Str {
        private String s;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
