package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/11 19:28
 * @description TODO
 **/
public class minCostClimbingStairs_ {
    public int minCostClimbingStairs(int[] cost) {

        //dp[i]表示爬到第i层需要最小的cost
        //dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        int[]dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i = 2; i <cost.length; i++) {
          dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
