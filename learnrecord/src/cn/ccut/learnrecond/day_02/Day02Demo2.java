package cn.ccut.learnrecond.day_02;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Day02Demo2 {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是Run1");
            }
        };
        r1.run();

        Runnable r2 = () -> {
            System.out.println("我是函数式接口 r2...");
        };
        r2.run();

        Runnable r3 = () -> System.out.println("我是函数式接口 r3...");
        r3.run();
    }

    @Test
    public void test2() throws Exception {
        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "hello---c1";
            }
        };

        Callable<String> c2 = () -> {return "hello-c2";};
        Callable<String> c3 = () -> "hello---c3";

        System.out.println(c1.call());
        System.out.println(c2.call());
        System.out.println(c3.call());
    }

    @Test
    public void test3() {
        UserMaper u1 = new UserMaper() {
            @Override
            public void insert(User u) {
                System.out.println("Hello word_" + u);
            }
        };

        UserMaper u2 = (user) -> System.out.println("Hello word_" + user);
        UserMaper u4 = user -> System.out.println("Hello word_" + user);
        UserMaper u3 = (User user) -> {System.out.println("Hello word_" + user);};

        u1.insert(new User());
        u2.insert(new User());
        u3.insert(new User());
    }

    interface UserMaper {
        void insert(User u);
    }

    class User {

    }

    @Test
    public void test4() {
        Order r0 = new Order() {
            @Override
            public int insert(int r) {
                return r;
            }
        };
        System.out.println(r0.insert(0));

        Order r1 = (r) -> {return r;};
        System.out.println(r1.insert(1));

        Order r2 = (int r) -> {return 2;};
        System.out.println(r2.insert(2));

        Order r3 = (r) -> r;
        System.out.println(r3.insert(3));

        Order r4 = r -> r;
        System.out.println(r4.insert(4));


    }

    interface Order {
        int insert(int r);
    }

    @Test
    public void test5() {
        Function<Integer, Integer> f1 =  x -> {
            int sum = 0;
            for (int i = 0; i < x; i++) {
                sum += i;
            }
            return sum;
        };

        System.out.println(f1.apply(10));
    }

    @Test
    public void test6() {
        Runnable r1 = () -> get();
        Runnable r2 = () -> exec();
//        Runnable r3 = () -> 10;

        Foo f1 = () -> get();
//        Foo f2 = () -> exec();

    }

    public int get() {
        return 10;
    }

    public void exec() {

    }

    interface Foo {
        int get();
    }

    @Test
    public void test7() {
        BiFunction<String, String, Integer> bf1 = (a, b) -> a.length() + b.length();
        System.out.println(bf1.apply("java", "se"));
    }

    @Test
    public void test8() {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("J2ee"));
    }

    @Test
    public void test9() {
        char c = 'a';
    }

    @Test
    public void test10() {
        Consumer<String> c1 = a -> {};

        Supplier<String> s = () -> "stirng";
    }

    @Test
    public void test11() {
        Consumer<String> c = (x) -> {
            System.out.println(x);
        };
        c.accept("hello word");

        Function<String, String> f = (str) -> str.toUpperCase();
        System.out.println(f.apply("j2EE"));
    }
}


