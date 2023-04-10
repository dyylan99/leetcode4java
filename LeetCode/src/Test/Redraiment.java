package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 15:37
 * @description TODO
 *
 * 最长递增子数组
 **/
public class Redraiment {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int length = sc.nextInt();
        int[] nums=new int[length];
        for (int i = 0; i < length; i++) {
            nums[i]=sc.nextInt();
        }
        //dp[i]为包含nums[i]在内的最长连续递增子数组
        int []dp=new int[length];
        //dp[i]=dp[i-1]+1
        Arrays.fill(dp,1);
        int res=1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(dp[i],res);
        }
        System.out.println(res);
    }
}
