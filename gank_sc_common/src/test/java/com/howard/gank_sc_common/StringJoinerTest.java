package com.howard.gank_sc_common;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerTest {
    @Test
    public void test(){
        List<String> list = ImmutableList.of("Hollis","hollischuang","Java干货");
        //show like Hollis,hollischuang,Java干货
        String r1 = list.stream().reduce((a,b)->a + "," + b).get();
        System.out.println(r1);
        String r2 = list.stream().collect(Collectors.joining(","));
        System.out.println(r2);
        System.out.println(r1.equals(r2));

        StringJoiner sj1 = new StringJoiner(",","[","]");
        sj1.add("Hollis").add("hollischuang").add("Java干货");
        System.out.println(sj1);




    }
}
