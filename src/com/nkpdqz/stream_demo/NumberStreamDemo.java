package com.nkpdqz.stream_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreamDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>(){{
            add(new Person("jack",12));
            add(new Person("nkpdqz",21));
            add(new Person("tony",20));
            add(new Person("niko",30));
        }};

        IntStream intStream = list.stream().mapToInt(Person::getAge);
        //数值流转化为流
        //Stream<Integer> boxed = intStream.boxed();
        int sum = intStream.sum();
        System.out.println(sum);
    }
}
