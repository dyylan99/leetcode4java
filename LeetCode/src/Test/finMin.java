package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 19:55
 * @description TODO
 **/
public class finMin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        long n = sc.nextLong();
        long x=1;
        long y=1;
        //先增加x,增加x找到最小值后再在这个[x-1,x+1]这个区间增加y
        long res=Integer.MAX_VALUE;
        long t=get(x,y,n);
        x=2;
        while (t<res){
             res=Math.min(res,t);
            x++;
            t=get(x,y,n);
        }
        //找到拐点x
        long tmp=x;
        x=x-2;

        if(x<2){
            System.out.println(x+" "+y);
            return;
        }
        y=3;
        t=get(x,y,n);
        while (x<=tmp){
            while (t<res){
                res=Math.min(res,t);
                y++;
                t=get(x,y,n);
            }
            x++;
        }
        System.out.println(x+" "+y);
    }

    public static long get(long x,long y,long n){
        return Math.abs(getX(x)*y-y-n);
    }

    public static long getX(long x){
        if(x==1)return 1;
        return getX(x-1)*x;
    }
}
