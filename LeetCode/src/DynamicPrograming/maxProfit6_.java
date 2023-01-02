package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/2 12:36
 * @description 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 *
 * 714. 买卖股票的最佳时机含手续费
 **/
public class maxProfit6_ {
    public int maxProfit(int[] prices, int fee){
        //dp[0]表示持有股票的最大金额
        //dp[1]表示未持有股票的最大金额
        //dp[0]=dp[1](上一天的情况)-prices[i]-fee或者dp[0]
        //dp[1]=dp[1]或者dp[0]+prices[i]
        //初始化
        int[]dp=new int[2];
        dp[0]=-prices[0]-fee;
        dp[1]=0;
        for (int i = 1; i <prices.length ; i++) {
            dp[0]= Math.max(dp[0],dp[1]-prices[i]-fee);
            dp[1]=Math.max(dp[1],dp[0]+prices[i]);
        }
        return dp[1];
    }
}
