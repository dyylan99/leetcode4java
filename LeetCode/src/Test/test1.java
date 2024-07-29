package Test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/9 22:26
 * @description TODO
 **/

public class test1 {
    @Test
    public void test() throws InterruptedException {
        CountDownLatch cdl=new CountDownLatch(3);
       new Thread(()->{
           System.out.println(1);
           cdl.countDown();
       }).start();
        new Thread(()->{
            System.out.println(2);
            cdl.countDown();

        }).start();
        new Thread(()->{
            System.out.println(3);
            cdl.countDown();

        }).start();
        cdl.await();
        System.out.println("end...");

    }
}
