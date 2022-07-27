package org.li;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamUsage {
    public static void main(String[] args) {
        Optional<Integer> op = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .filter(x -> x % 2 == 0)
                .sorted((a, b) -> b - a)
                .findFirst();
        System.out.println(op.get());
    }
}
