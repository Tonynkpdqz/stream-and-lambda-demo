package com.nkpdqz.lambda_demo;

import java.util.Arrays;
import java.util.function.Function;

/*
 * 函数型接口：Function  —>  R apply(T t) 传入T，得到R；
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String,Integer> function = String::length;
        Integer nkpdqz = function.apply("nkpdqz");
        System.out.println(nkpdqz);

        Function<Integer,Integer[]> fun = Integer[]::new;
        Integer[] nothing = fun.apply(5);
        Arrays.stream(nothing).forEach(System.out::println);
    }
}
