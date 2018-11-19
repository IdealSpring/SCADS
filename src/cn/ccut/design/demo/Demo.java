package cn.ccut.design.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.removeIf(num -> num % 2 == 0);
        list.forEach(x -> System.out.println(x));
    }

    /**
     * 使用forEach()遍历集合
     *
     * @param list  要遍历的集合
     */
    public static void printList(List<Integer> list) {
        list.forEach(num -> System.out.println(num));
    }
}
