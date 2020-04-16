package com.nkpdqz.stream_demo;

import java.util.stream.Stream;

//并行流
/*
 * 使用并行流时，要注意数据源的可分解性：
 * 数据源	可分解性
    ArrayList	极佳
    LinkedList	差
    IntStream.range	极佳
    Stream.iterate	差
    HashSet	      好
    TreeSet	      好
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        //先生成1-100的数字，然后并行求和
        Integer i = Stream.iterate(1, a -> a + 1).limit(100).parallel().reduce(0, Integer::sum);
        System.out.println(i);
    }

}
