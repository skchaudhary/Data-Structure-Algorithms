package com.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConversionIntoStream {
    public static void main(String[] args) {
        // find first on stream as using Arrays
        System.out.println("Arrays.asList.........");
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        // find first on stream as using Arrays
        System.out.println("Stream.of.........");
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);

        // using stream range
        System.out.println("IntStream.range.........");
        IntStream.range(1, 5).forEach(System.out::println);
    }
}
