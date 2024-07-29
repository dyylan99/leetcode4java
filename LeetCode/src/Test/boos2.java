package Test;

import java.util.Scanner;

/**
 *@author Dylan
 *@date 2023/9/27 16:07
 *@version 1.0
 *@description TODO
 **/
public class boos2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long num = sc.nextLong();
        int count=0;
        while (num>=10){
            num=get(num);
            count++;
        }
        System.out.println(count);
    }

    private static long get(long num){
        if (num<10){
            return num;
        }
        long res=1;
        while (num>0){
            long t=num%10;
            res*=t;
            num/=10;
        }
        return res;
    }
}
