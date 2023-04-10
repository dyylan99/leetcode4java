package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/4 20:01
 * @description TODO
 **/
public class goodKNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();


         System.out.println(goodKNum(l,r,k));
        }
    }
    public static int goodKNum(long l,long r,long k){
        int res=0;
        List<Long>list=new ArrayList<>();
        double j=0;
        while (true){
            long num= (long) Math.pow(k,j);
            if(num<=r){
                list.add(num);
                j=j+1;
            }else{
                break;
            }
        }
        long sum=0;
        long[]sumNums=new long[list.size()+1];
        for (int i = 0; i < list.size(); i++) {
            sumNums[i]=sum;
            sum+=list.get(i);
        }
        sumNums[list.size()]=sum;
        for (long i = l; i <=r ; i++) {
            if(i==sumNums[sumNums.length-1]+list.get(list.size()-1)){
                res++;
            }
            if(KNum(i,sumNums)){
                res++;
            }
        }
        return res;
    }

    public static boolean KNum(long num,long[]sumNums){
        if(num==1){
            return true;
        }
        for (int i = 0; i < sumNums.length; i++) {
            if(num==sumNums[i]){
                return true;
            }
        }
        return false;
    }

}
