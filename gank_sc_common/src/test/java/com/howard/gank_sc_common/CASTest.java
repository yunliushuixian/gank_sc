package com.howard.gank_sc_common;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CASTest {
    static int data = 0;
    AtomicInteger atomicInteger = new AtomicInteger();


    @Test
    public void testRange() {
        IntStream.range(0, 2).forEach(i -> System.out.println(i));
    }

    @Test
    public void test() {
        IntStream.range(0, 2).forEach((i) -> new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 100).forEach(y -> {
                data++;
                atomicInteger.incrementAndGet();
            });
        }).start());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
        System.out.println(atomicInteger.get());
    }
}
