package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/1 15:11
 * @description 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *121. 买卖股票的最佳时机
 **/
public class maxProfit_ {
    public int maxProfit(int[] prices) {
        /**
         * 确定dp数组（dp table）以及下标的含义
         * dp[i][0] 表示第i天持有股票所得最多现金 ，这里可能有同学疑惑，本题中只能买卖一次，持有股票之后哪还有现金呢？
         *
         * 其实一开始现金是0，那么加入第i天买入股票现金就是 -prices[i]， 这是一个负数。
         *
         * dp[i][1] 表示第i天不持有股票所得最多现金
         */
        int len=prices.length;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < len; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[len-1][1];
    }

    /**
     * 优化版本
     */
    public int maxProfit1(int[] prices){
        int[] dp=new int[2];
        dp[0]=-prices[0];
        for (int i = 1; i <=prices.length ; i++) {
            dp[0]=Math.max(dp[0],-prices[i-1]);
            dp[1]=Math.max(dp[1],dp[0]+prices[i-1]);
        }
        return dp[1];
    }
}
