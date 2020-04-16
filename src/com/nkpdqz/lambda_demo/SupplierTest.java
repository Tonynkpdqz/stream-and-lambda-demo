package com.nkpdqz.lambda_demo;

import java.util.function.Supplier;

/*
 * 供给型接口：Supplier  —>  T get() 不用传入参数，有返回值
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = ()->"this is me";
        System.out.println(stringSupplier.get());
    }
}
