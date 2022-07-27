package org.li.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerUsage {

    public static void main(String[] args) {
        output(s -> System.out.println("使用system.out输出文本: \n" + s));
        intOutput(n-> System.out.println("number: \n" + n));
    }

    public static void output(Consumer<String> consumer) {
        String msg = "天涯若比邻";
        consumer.accept(msg);
    }

    public static void intOutput(IntConsumer consumer) {
        int num = 10;
        consumer.accept(num);
    }
}
