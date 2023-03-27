package Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/26 11:28
 * @description TODO
 **/
public class Cake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while(in.hasNextInt()){
            //总共能烤多少个蛋糕
            int n=in.nextInt();
            //已经烤好了多少个蛋糕
            int m=in.nextInt();
            //a
            int a=in.nextInt();
            //b
            int b=in.nextInt();
            int[]cake=new int[m];
            for (int i = 0; i < m; i++) {
                cake[i]=in.nextInt();
            }
            if(satisfy(n,a,b,cake)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean satisfy(int n,int a,int b,int[]cake){

        if(n<2){
            return false;
        }
        Arrays.sort(cake);
        int m=cake.length;
        //全部烤完了
        if(m==n){
            boolean i=Math.max(a,b)==cake[cake.length-1];
            boolean j=Math.min(a,b)==cake[0];
            return i&&j;
        }else if(m==n-1){
            //还有一个能烤
            boolean i=Math.max(a,b)==cake[cake.length-1];
            boolean j=Math.min(a,b)==cake[0];
            return i||j;
        }else{
            //还能烤两个以上
            //需要判断烤的蛋糕的最小值是否为小于min或者最大值是否大于max
            if(cake[0]==1&&Math.min(a,b)!=1){
                return false;
            }
            if(cake[cake.length-1]>Math.max(a,b)){
                return false;
            }
            return true;
        }

    }
}
