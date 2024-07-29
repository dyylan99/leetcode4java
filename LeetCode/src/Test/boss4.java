package Test;

import java.util.Scanner;

/**
 *@author Dylan
 *@date 2023/9/27 16:12
 *@version 1.0
 *@description TODO
 **/
public class boss4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[]nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int[]dp=new int[4];
        dp[0]=-nums[0];
        dp[1]=0;
        dp[2]=-nums[0];
        dp[3]=0;
        for(int i=1;i<=nums.length;i++){
            dp[0]=Math.max(dp[0],-nums[i-1]);
            dp[1]=Math.max(dp[1],dp[0]+nums[i-1]);
            dp[2]=Math.max(dp[2],dp[1]-nums[i-1]);
            dp[3]=Math.max(dp[3],dp[2]+nums[i-1]);
        }
        System.out.println(dp[3]);
    }
}
