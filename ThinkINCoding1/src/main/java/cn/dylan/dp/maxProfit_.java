package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 15:42
 * @description 121. 买卖股票的最佳时机
 **/
public class maxProfit_ {
    public int maxProfit(int[] prices) {
        //dp[i][0]代表第i天未持有股票的最大利益
        //dp[i][1]代表第i天持有股票的最大利益
        int[][]dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
