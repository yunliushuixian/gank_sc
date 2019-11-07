package com.howard.gank_sc_common;


import com.howard.gank_sc_common.module.Person;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Predicate;


public class OptionalTest {

    @Test
    public void createOptional() {

        //创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException 。
        //ofNullable 可以传空的参数
        Optional<Person> optionalPerson = Optional.of(new Person("1", "admin", 10, "gank", "engineer", "none"));
        if (optionalPerson.isPresent()) {
            System.out.println(optionalPerson.get());
        } else {
            System.out.println("optionalPerson没有数据");
        }

        Optional<Person> empty = Optional.empty();
        if (empty.isPresent()) {
            System.out.println(empty.get());
        } else {
            System.out.println("empty没有数据");
        }

        Person person2 = optionalPerson.orElse(new Person("2", "admin2", 10, "gank", "engineer", "none"));
        System.out.println("person2:" + person2);

        Person person3 = empty.orElse(new Person("3", "admin3", 10, "gank", "engineer", "none"));
        System.out.println("person3:" + person3);

        Person person4 = empty.orElseGet(() -> new Person("4", "admin4", 10, "gank", "engineer", "none"));
        System.out.println("person4:" + person4);

        //如果有值则将其返回，否则抛出supplier接口创建的异常。
        try {
            empty.orElseThrow(() -> new Exception("自定义异常"));
        } catch (Exception e) {
            System.out.println("异常是:" + e.getMessage());
        }

        //如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
        //flatMap 返回值没封装成Optional
        Optional<Person> person5 = optionalPerson.map(p -> {
            p.setComment(p.getComment().toUpperCase());
            return p;
        });
        System.out.println("person5:" + person5.orElse(new Person()));

        //如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
        Optional<Person> person6 = optionalPerson.filter(p -> p.getId().equals("1"));
        System.out.println("person6:" + person6.orElse(new Person()));

        Optional<Person> person7 = optionalPerson.filter(p -> p.getId().equals("2"));
        System.out.println("person7:" + person7.orElse(new Person()));

        Predicate<Person> personPredicate = p -> p.getId().equals("1");
        Optional<Person> person8 = optionalPerson.filter(personPredicate);
        System.out.println("person8:" + person8.orElse(new Person()));
    }

    //

}
