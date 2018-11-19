package cn.ccut.design.algorithm.arrayandlink.stack;

import org.junit.Test;

import java.util.Stack;

public class StackDemo {
    @Test
    public void test1() {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("java");

        System.out.println("empty:" + stack.empty());
        System.out.println("peek:" + stack.peek());
        System.out.println("peek:" + stack.search("world"));

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
