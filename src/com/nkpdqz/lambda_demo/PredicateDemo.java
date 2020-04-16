package com.nkpdqz.lambda_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * 内置函数式接口————Predicate
 * Predicate  —>  bool test(T t)  传入参数，没有bool类型；
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> predicate = my_int->{
            return my_int>0;
        };
        System.out.println(predicate.test(2));
        Predicate<Integer> negate = predicate.negate();
        boolean test = negate.test(-5);
        System.out.println(test);

        String[] strings = new String[]{"tony","nkpdqz","iamnl","dawn","i","tonynkpdqz"};
        List<String> filterStrings = getFilterStrings(strings, s -> s.length() > 4);
        filterStrings.forEach(System.out::println);

        List<Integer> list = new ArrayList<Integer>(){{
            new Integer(1);
            new Integer(2);
            new Integer(3);
            new Integer(4);
            new Integer(5);
        }};
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        List<Integer> filterNumbers = getFilterNumbers(numList, num -> num > 0);
        filterNumbers.forEach(System.out::println);
    }

    //把字符串符合某条件的过滤出来
    public static List<String> getFilterStrings(String[] strings,Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for (String s:strings) {
            boolean test = predicate.test(s);
            if (test)
                list.add(s);
        }
        return list;
    }

    public static List<Integer> getFilterNumbers(List<Integer> list,Predicate<Integer> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
