package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 16:00
 * @description 70. 爬楼梯
 **/
public class climbStairs_ {
    public int climbStairs(int n) {
        int[]dp=new int[n];
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
