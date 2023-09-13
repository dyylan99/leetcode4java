package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/12 19:29
 * @description TODO
 **/
public class test2 {
    public static void main(String[] args) {
        //计算组合数
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int len=s.length();
        int res=0;
        for (int i = 1; i <=len; i++) {
            res+=fun1(len,i);
        }
        System.out.println(res);
    }

    public static int fun1(int n, int m){
       int k=1, j=1, l=1;
        for (int i = 1; i <=n ; i++) {
            k*=i;
        }
        for (int i = 1; i <=m ; i++) {
            j*=i;
        }

        for (int i = 1; i <=n-m ; i++) {
            l*=i;
        }
        return k/(j*l);


    }
}
