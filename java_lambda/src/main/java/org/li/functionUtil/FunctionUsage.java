package org.li.functionUtil;


import java.util.Random;
import java.util.function.Function;

public class FunctionUsage {
    public static void main(String[] args) {
        int len = 10;
        Function<Integer, String> randomStringFunction = l -> {
            String chars = "abcdefghijklmnopqrstuvwxyz01234567890";
            StringBuffer stringBuffer = new StringBuffer();
            Random random = new Random();
            for (int i = 0; i < l; i++) {
                int position = random.nextInt(chars.length());
                stringBuffer.append(chars.charAt(position));
            }
            return stringBuffer.toString();
        };
        // 调用定义好的lambda表达式
        String randomString = randomStringFunction.apply(10);
        System.out.println(randomString);
    }


}
