package org.li;

import java.util.*;

/**
 * Hello world!
 */
public class LambdaApp {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike");

        sortByJava(names);
        sortByLambda(names); // 使用lambda 可以快速简化语法
        myLambda(names); // lambda 若有大量语句，则使用 { } 包括
    }

    private static void myLambda(List<String> names) {
        Collections.sort(names, (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return a.compareTo(b);
        });
        System.out.println(names);
    }

    private static void sortByLambda(List<String> names) {
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }

    private static void sortByJava(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
