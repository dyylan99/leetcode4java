package Test;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 15:02
 * @description TODO
 **/
public class primeFactors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int i = sc.nextInt();
            int y=2;
            while (i!=1){
                if(i%y==0){
                    System.out.println(y+" ");
                    i/=y;
                }else{
                    if(y>i/y){
                        y=i;
                    }else {
                        y++;
                    }
                }
            }
        }
        Integer.bitCount(1);

    }
    @Test
    public void test(){
        int t=3;
        for (int i = 0; i < 32; i++) {
            if((t&1)==1){
                System.out.println("i: "+i);
            }
            t=t>>>1;
        }
    }
}
