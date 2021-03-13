package com.learn.javaCollection;

import java.util.*;

public class HashMapFeatures
{
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(5, "sanjay");
        map.put(2, "ram");
        map.put(6, "aman");
        map.put(4, "brajesh");
        map.put(1, "zebra");

        for (Map.Entry<Integer, String> e:map.entrySet())
            System.out.println(e.getKey()+" " +e.getValue());

        List<Map.Entry<Integer, String>> ls = new ArrayList<>(map.entrySet());
        Collections.sort(ls, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        HashMap<Integer, String> hm=new LinkedHashMap<>();
        for (Map.Entry<Integer, String> e:ls)
            hm.put(e.getKey(), e.getValue());

        System.out.println("After sorting");
        for (Map.Entry<Integer, String> e:hm.entrySet())
            System.out.println(e.getKey()+" " +e.getValue());
    }
}
