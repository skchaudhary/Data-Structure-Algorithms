package com.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class DataStructureApplication {
    public static void main(String[] numberArray) {
        Person p1=new Person("ABC");
        Person p2=new Person("BCD");
        TreeSet<Person> treeSet=new TreeSet<>();
        treeSet.add(p1);
        treeSet.add(p2);
        System.out.println(treeSet.size());
        Optional<String> name = Optional.ofNullable(null);
        name.ifPresent(System.out::println).orElse("EMPTY");
    }
}

class Person implements Comparable{

    String name;
    public  Person(String name) {
        this.name=name;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
