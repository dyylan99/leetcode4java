package OneToFifty;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/19 9:23
 * @description TODO
 **/
public class OneToTwenty {
    public static void main(String[] args) {
        //int count = 0;
        //Scanner scanner = new Scanner(System.in);
        //while(scanner.nextInt()>0){
        //    count++;
        //}
        //根据不同情况选择不同的算法
        //---------------
        long start1 = System.currentTimeMillis();
        System.out.println(getcm2(7,5));
        long end1 = System.currentTimeMillis();
        System.out.println("method2:"+(end1-start1)+"ms");
        long start = System.currentTimeMillis();
        System.out.println(getcm1(7,5));

        long end = System.currentTimeMillis();
        System.out.println("method1:"+(end-start)+"ms");

    }

    public static long getcm1(long a,long b)
    {
        long t=a;

       for(;a%b!=0;a+=t){

       }
       return a;
    }
    public static long getcm2(long a ,long b){
        long t=a>b?a:b;
        if(t==a)
        {
            for(;a%b!=0;a+=t){

            }
            return a;
        }
        else{
            for(;b%a!=0;b+=t){

            }
            return b;
        }
    }

}
