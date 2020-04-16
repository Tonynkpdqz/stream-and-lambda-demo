package com.nkpdqz.stream_demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>(){{
            add(new Person("jack",12));
            add(new Person("nkpdqz",21));
            add(new Person("tony",20));
            add(new Person("niko",30));
        }};
        Stream<Person> stream = list.stream();
        //并行流
        Stream<Person> personStream = list.parallelStream();
        List<Person> personList = list.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
        personList.forEach(System.out::println);
        List<Person> personList1 = list.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).limit(3).skip(1).collect(Collectors.toList());
        personList1.forEach(System.out::println);
        List<String> stringList = list.stream().map(Person::toString).collect(Collectors.toList());
        stringList.forEach(System.out::println);
        //这个方法其实有装箱成本，所以java推出了数值流
        Integer reduce = list.stream().map(Person::getAge).reduce(0, Integer::sum);
        System.out.println(reduce);
        List<String> flatList = new ArrayList<String>(){{
            add("aaa bbb ccc");
            add("fff eee ddd");
            add("ccc mmm aaa");
        }};
        List<String> collect = flatList.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Stream<String> aaa = Stream.of("aaa", "ccc", "mmm");
        Optional<String> s = aaa.reduce((s1, s2) -> s1 + s2);
        s.ifPresent(System.out::println);
        String collect1 = list.stream().map(Person::getName).collect(Collectors.joining("-"));
        System.out.println(collect1);
        String collect2 = list.stream().map(Person::getName).collect(Collectors.joining(",","This is the list:",".good luck!"));
        System.out.println(collect2);
        Map<Integer, List<Person>> collect4 = list.stream().collect(Collectors.groupingBy(Person::getAge));
        //按组收集数据（类似group by之后对每组进行操作）
        Map<Integer, Integer> collect5 = list.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.summingInt(Person::getAge)));
        //按照条件分区，true对应一个list，false对应另一个
        Map<Boolean, List<Person>> booleanListMap = list.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 20));
    }
}
