package org.li;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalUsage {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 3, 1, 2, 3, 4};
        Predicate<Integer> predicate = (n) -> n > 4;
        boolean result = predicate.test(10);
        System.out.println(result);
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 41, 2, 312, 31, 112);
        // 判断偶数和奇数
        isTwo(list, (i) -> i % 2 == 1); // 奇数
        isTwo(list, (i) -> i % 2 != 1); // 偶数
    }

    /**
     * 根据条件来过滤奇数还是偶数
     *
     * @param list
     * @param predicate
     */
    private static void isTwo(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }
}