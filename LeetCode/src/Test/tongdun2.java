package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/22 19:27
 * @description TODO
 **/
public class tongdun2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=sc.nextInt();
        }
        int[] dp=new int[V+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = V; j>=nums[i]; j--) {
                dp[i]=Math.max(dp[i],dp[j-nums[i]]+nums[i]);
            }
        }
        System.out.println(V-dp[V]);

    }
}
