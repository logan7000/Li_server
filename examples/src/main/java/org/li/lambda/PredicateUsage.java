package org.li.lambda;

import java.util.function.Predicate;

public class PredicateUsage {
    public static void main(String[] args) {
        isOddNumber(3, n -> n % 2 == 1);
        isOddNumber(4, n -> n % 2 == 1);
        isLegalParam(3, n -> n != null);
    }

    private static void isLegalParam(int i, Predicate predicate) {
        System.out.println(String.format("当前参数%s合法的", predicate.test(i) ? "是" : "不是"));
    }

    private static void isOddNumber(int num, Predicate<Integer> predicate) {
        System.out.println(String.format("当前数字%s奇数", predicate.test(num) ? "是" : "不是"));
    }

}
