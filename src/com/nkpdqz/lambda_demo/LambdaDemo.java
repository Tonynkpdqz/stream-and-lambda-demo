package com.nkpdqz.lambda_demo;

/*
 * 总结：-> 箭头操作符
 *  ->左侧：Lambda形参列表，->对应->接口中的抽象方法的形参列表。
 *  ->右侧：重写方法的方法的具体内容。
 *  ->左边：
         （1）因为可以进行类型推断，所以可以不用写形参的类型；
         （2）如果只有一个参数，（）可以不写。
    ->右边：
         （1）{}将方法体的具体内容包裹起来；
         （2）方法体只有一条语句，{}可以不写；
         （3）如果方法体只有一条并且这条语句就是返回语句，return关键字可以不写。
 */
public class LambdaDemo {

    public static void main(String[] args) {
        MyFunctionalInterface functionalInterface = s -> s;
        System.out.println(functionalInterface.funMethod("hello lambda!"));
    }
}
/*
 * 四种内置函数式接口见其他类
 * 消费型接口：Consumer  —>  void accept(T t)  传入参数，没有返回值类型；
 * 断定型接口：Predicate   —>   boolean test(T t) 传入T，返回布尔类型；
 * 函数型接口：Function    —>   R apply(T t) 传入T，得到R；
 * 供给型接口：Supplier     —>  T get() 不用传入参数，有返回值
 */
