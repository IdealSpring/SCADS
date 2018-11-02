package cn.ccut.learnrecond.day_02;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Day02Demo3 {
    @Test
    public void test1() {
        Supplier<String> s = () -> Day02Demo3.put();
        System.out.println(s.get());

        Supplier<String> s2 = Day02Demo3::put;
        System.out.println(s2.get());

    }
    public static String put() {
        return "java";
    }

    @Test
    public void test2() {
        Consumer<Integer> c = (size) -> Day02Demo3.con(size);
        Consumer<Integer> c2 = Day02Demo3::con;
        c.accept(10);
        c2.accept(100);
    }

    public static void con(Integer integer) {
        System.out.println("size:" + integer);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("a", "b");
        list.stream();
    }

    @Test
    public void test4() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        map.forEach((x1, x2) -> System.out.println(x1 + "=" + x2));
    }

    @Test
    public void test5() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        // x1和x2分别为键和值的变量，x1+x2为对所有值的操作
        map.replaceAll((x1, x2) -> x1 + x2);
        map.forEach((x1, x2) -> System.out.println(x1 + "=" + x2));
    }

    @Test
    public void test6() {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            Object o = new Object();
            list.add(o);
            set.add(o.hashCode());
        }

        System.out.println("10000000");
        System.out.println(set.size());
    }

    @Test
    public void test7() {
        HashMap<Integer, Integer> map = new HashMap<>(12, 0.7f);
    }

    @Test
    public void test8() {
        String i = "hello";
        switch (i){
            case "hello":
                System.out.println("hello");
        }
    }
}
