package cn.ccut.learnrecond.day_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day02Demo {
    @Test
    public void test() {
        Integer i = 1;
        Integer j = 2;
        String str = "hello word";

        System.out.println(i.getClass() == j.getClass());
        System.out.println(j.getClass());
        System.out.println(str.getClass());
    }

    @Test
    public void test1() {
        String[] str = {"大", "王", "叫", "我", "来", "巡", "山"};
        List<String> list = Arrays.asList(str);

        /**
         * 迭代器的forEachRemaining方法和集合本身的forEach方法功能是相同的
         */
        list.forEach(x -> System.out.println(x));
        System.out.println("------------------");
        list.iterator().forEachRemaining(x -> System.out.println(x));
    }

    @Test
    public void test2() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        System.out.println("过滤前：" + list);
        list.removeIf(i -> i % 2 == 0);     // 过去掉偶数
        System.out.println("过滤后：" + list);
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("操作前：" + list);
        list.replaceAll(x -> x * 10);     // 过去掉偶数
        System.out.println("操作后：" + list);
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>(Arrays.asList(19, 22, 39, 44, 15, 66, 37, 88, 19));
        System.out.println("排序前：" + list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("排序后：" + list);
    }

}
