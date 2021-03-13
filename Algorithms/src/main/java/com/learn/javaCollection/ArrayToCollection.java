package com.learn.javaCollection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayToCollection
{
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 3, 7, 5, 9, 12, 1, 32, 4, 43};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        System.out.println(list);
        System.out.println(set);

        List<Integer> list1 = IntStream.of(arr).boxed().collect(Collectors.toList());
        Set<Integer> set1 = IntStream.of(arr).boxed().collect(Collectors.toSet());
        System.out.println(list1);
        System.out.println(set1);

        Integer[] arr1 = new Integer[]{2, 4, 1, 3, 7, 5, 9, 12, 1, 32, 4, 43};
        List<Integer> list2 = Arrays.stream(arr1).collect(Collectors.toList());
        Set<Integer> set2 = Arrays.stream(arr1).collect(Collectors.toSet());
        System.out.println(list2);
        System.out.println(set2);

        List<Integer> list3 = Arrays.asList(arr1).stream().collect(Collectors.toList());
        Set<Integer> set3 = Arrays.asList(arr1).stream().collect(Collectors.toSet());
        System.out.println(list3);
        System.out.println(set3);
    }
}
