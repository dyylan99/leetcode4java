package DynamicPrograming;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/28 10:18
 * @description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 123. 买卖股票的最佳时机 III
 **/
public class maxProfit3_ {
    /*
     * 定义 5 种状态:
     * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
     */
    public int maxProfit(int[] prices) {
        int[][]dp=new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i][3]+prices[i]);
        }
        return dp[prices.length-1][4];
    }

    //空间优化版本
    public int maxProfit1(int[] prices) {
        int[] dp = new int[4];
        // 存储两次交易的状态就行了
        // dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        // dp[1]代表第一次交易的卖出
        dp[1] = 0;
        // dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        // dp[3]代表第二次交易的卖出
        dp[3] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

}
