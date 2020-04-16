package com.nkpdqz.lambda_demo;

import java.util.function.Consumer;

/*
 * 内置函数式接口————Consumer
 * Consumer  —>  void accept(T t)  传入参数，没有返回值类型；
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> consumer1 = my_int->{
            System.out.println("myInt is:" + my_int);
        };
        Consumer<String> consumer = System.out::println;
        consumer1.accept(12);
        consumer.accept("this is Consumer");
    }
}
