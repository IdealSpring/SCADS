package cn.ccut.newfeatures.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    private static void test3() {

    }

    private static void test2() {
        Function<Integer, Integer> function = x -> {
            int count = 0;
            for (int i = 0; i < x; i++) {
                count += i;
            }
            return count;
        };
        System.out.println(function.apply(10));

    }

    private static void test1() {
        List<String> list = Arrays.asList("a", "ab", "abc", "abcd");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1 : 1;
            }
        });

        Collections.sort(list, (str1, str2) -> str1.length() > str2.length() ? -1 : 1);

        System.out.println(list);
    }
}