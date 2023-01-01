package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/1 15:21
 * @description 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 * 122. 买卖股票的最佳时机 II
 **/
public class maxProfit2_ {
    public int maxProfit(int[] prices) {
        /**
         * 0表示持有股票的最大现金,1表示不持有的最大金额
         */

        int[][]dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
