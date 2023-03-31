package Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 21:07
 * @description n个学生围成一圈，编号从1到n。每个学生将从1开始报数，报到素数的人出列，剩下的人继续报数，试求最终留下来的人的编号是多少
 **/
public class baoshu {

    public static final int N=(int)Math.pow(10,6);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int[]prime=new int[N];// prime[index] = 0,index为素数； prime[index] = 1，index为合数
        getPrime(prime);
        Queue<Integer>queue=new ArrayDeque<>();
        for (int i = 1; i <= nextInt; i++) {
            queue.add(i);
        }
        //模拟报数
        int count=1;
        while (queue.size()>1){
            if(prime[count]==1){
                //合数不出列
                queue.add(queue.peek());
            }
            queue.poll();
            count++;
        }
        System.out.println(queue.peek());
    }


   // 欧拉筛选打了一个素数表，时间复杂度为O(nlogn)。
    public static void getPrime(int[]prime){
        for (int i = 2; i < prime.length; ++i) {
            if(prime[i]==0){
                for (int j = i+i; j <prime.length ; j+=i) {
                    prime[j]=1;
                }
            }
        }
    }
}
