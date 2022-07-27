package org.li.functionUtil;

import java.util.function.Consumer;

public class ConsumerUsage {
    public static void main(String[] args) {

        output(s ->
                System.out.println("打印： " + s)
        );
        output(s -> {
            System.out.println("使用网络输出，向XX网站发送数据包");
        });
    }


    private static void output(Consumer<String> consumer) {
        String text = "萍水相逢，尽是他乡之客。";
        consumer.accept(text);
    }
}
