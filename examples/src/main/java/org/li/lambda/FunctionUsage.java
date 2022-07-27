package org.li.lambda;


import java.util.function.Function;

/**
 * Function 一些函数
 */
public class FunctionUsage {
    public static void main(String[] args) {
        // 执行一些内置方法
        doAction(n -> "your number is " + n);
    }

    private static void doAction(Function<Integer, String> fn) {
        Integer param = 10;
        String result = fn.apply(param);
        System.out.println(result);
    }
}
