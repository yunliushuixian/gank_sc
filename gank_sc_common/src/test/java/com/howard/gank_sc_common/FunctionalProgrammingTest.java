package com.howard.gank_sc_common;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionalProgrammingTest {

    //Consumer	Consumer< T >	接收T对象，不返回值
    //Predicate	Predicate< T >	接收T对象并返回boolean
    //Function	Function< T, R >	接收T对象，返回R对象
    //Supplier	Supplier< T >	提供T对象（例如工厂），不接收值

    public void printMoney(Function<Integer,String> moneyFormat){
        System.out.println("我的存款"+moneyFormat.apply(100));
    }

    @Test
    public void testApply(){
        Function<Integer,Integer> times2= i->i*2;
        Function<Integer,Integer> square=i->i*i;

        System.out.println(times2.apply(3));

        System.out.println(times2.compose(square).apply(3));

        System.out.println(times2.andThen(square).apply(3));

        /**
         * Function.identity()返回当前正在执行的方法
         */
        System.out.println(Function.identity().compose(square).apply(3));
    }

    public static void main(String[] args) {
        int[] nums = {35,65,-55,100,95};

        int min = IntStream.of(nums).min().getAsInt();
        System.out.println(min);

        int min2 = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(min2);

        FunctionalProgrammingTest functionalProgrammingTest = new FunctionalProgrammingTest();
        Function<Integer,String> moneyFormat = i->i+1+"";

        functionalProgrammingTest.printMoney(moneyFormat.andThen(s->"人民币"+s));

    }
}
