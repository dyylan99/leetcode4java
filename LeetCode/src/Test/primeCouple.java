package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 17:32
 * @description 匈牙利算法
 **/
public class primeCouple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums=new int[n];
        //用于存储所有的奇数
        ArrayList<Integer> odds=new ArrayList<>();
        //用于存储所有的偶数
        ArrayList<Integer> evens=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
            if(nums[i]%2==1){
                odds.add(nums[i]);
            }else {
                evens.add(nums[i]);
            }
        }
        //下标对应已经匹配的偶数的下标，值对应这个偶数的伴侣
        int[] matchEven=new int[evens.size()];
        //记录伴侣的对数
        int count=0;
        for (int i = 0; i < odds.size(); i++) {
            //用于标记对应的偶数是否查找过
            boolean[]v=new boolean[evens.size()];

            if(find(odds.get(i),matchEven,evens,v)){
                ++count;
            }
        }
        System.out.println(count);

    }

    private static boolean find(int x, int[]matchEven, ArrayList<Integer>evens,boolean[]v){
        for (int i = 0; i < evens.size(); i++) {
            if(isPrime(x+evens.get(i))&&!v[i]){
                //没被访问过,并且可以和x组成素数伴侣
                v[i]=true;
                  /*如果i位置偶数还没有伴侣，则与x组成伴侣，如果已经有伴侣，并且这个伴侣能重新找到新伴侣，
                则把原来伴侣让给别人，自己与x组成伴侣*/
                if(matchEven[i]==0||find(matchEven[i],matchEven,evens,v)){
                    matchEven[i]=x;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPrime(int num){
        for (int i = 2; i*i <=num ; i++) {
            if(num%i==0){
                return false;
            }
        }

        return true;
    }
}
