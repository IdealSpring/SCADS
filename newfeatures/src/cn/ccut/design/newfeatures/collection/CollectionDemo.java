package cn.ccut.design.newfeatures.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class CollectionDemo {
    public static void main(String[] args) throws Exception {
        // test1();
        // test3();
        // test4();
        // test6();
        // Arrays.asList(1, 2, 3, 4).stream().filter(s -> s % 2 == 0).forEach(System.out::println);

        /**
         * parallel()方法是Stream接口的并行流
         */
        Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x -> {
            System.out.println(Thread.currentThread().getName());
        }).parallel().max(Integer::compareTo);
        System.out.println(max);
    }

    /**
     * Stream创建方式
     */
    private static void test3() throws Exception {
        // 1.通过数组创建
        String[] arr = {"a", "b", "c", "d", "e"};
        Stream<String> streamArr = Stream.of(arr);
        streamArr.forEach(System.out::println);

        // streamArr.forEach(x -> System.out.println(x));

        // Files.lines(Paths.get("d:/temp.txt")).forEach(System.out::println);
    }

    private static void test4() {
        // 2.通过集合创建
        Collection<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        Stream<String> streamCollection = collection.stream();
        streamCollection.forEach(System.out::println);
    }

    private static void test5() {
        // 3.通过Stream.generate()
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(100).forEach(System.out::println);
    }

    private static void test6() {
        // 4.通过Stream.iterate()
        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1);
        integerStream.limit(100).forEach(System.out::println);
    }



    private static void test1() {
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);

        /**
         * removeIf(Predicate<? super E> filter)的Predicate类型参数属于函数式接口(在类上明确标注了@FunctionalInterface)
         * 传入的 x -> x % 2 == 0 是Lambda表达式创建的。
         * 其实质是Predicate接口的匿名内部类
         */
        c.removeIf(x -> x % 2 == 0);
        System.out.println(c);
    }
}
