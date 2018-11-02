package cn.ccut.algorithm.arrayandlink.link;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 看完LinkedList源码，自己实现具有增删改查功能的基于双向链表数据结构的集合
 */
public class MyLinkedList <E> implements Iterable<E> {
    transient int size;     // 链表中元素的个数
    transient Node<E> first;    // 头结点
    transient Node<E> last;     // 尾节点

    // 这里仅提供了无参构造
    public MyLinkedList() {}

    // 增
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    // 在结尾处添加元素
    private void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    public boolean add(int index, E e) {
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }

        return true;
    }

    private void linkBefore(E e, Node<E> node) {
        Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, e, node);
        node.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }

        size++;
    }

    // 删
    public E remove(int index) {
        Node<E> oldNode = node(index);
        E element = oldNode.item;
        Node<E> pred = oldNode.prev;
        Node<E> succ = oldNode.next;

        oldNode.prev = oldNode.next = null;

        if (pred == null) {
            first = succ;
        } else {
            pred.next = succ;
        }

        if (succ == null) {
            last = pred;
        } else {
            succ.prev = pred;
        }

        size--;
        oldNode.item = null;

        return element;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.prev = null;
            x.item = null;
            x.next = null;
            x = next;
        }

        first = last = null;
        size = 0;
    }

    // 改
    public E set(int index, E e) {
        Node<E> node = node(index);
        E item = node.item;
        node.item = e;
        return item;
    }

    // 查
    public E get(int index) {
        return node(index).item;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> next = first;
            for (int i = 0; i < index; i++)
                next = next.next;
            return next;
        } else {
            Node<E> prev = last;
            for (int i = size - 1; i > index; i--)
                prev = prev.prev;
            return prev;
        }
    }

    // 返回迭代器
    public Iterator<E> iterator(int index) {
        return new Itr(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(0);
    }

    /**
     * 这里仅提供正向遍历迭代器，反向的和并行迭代器不提供了
     */
    private class Itr implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public Itr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;

            return lastReturned.item;
        }
    }

    /**
     * 链表节点数据结构类
     */
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
