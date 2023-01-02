package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/2 12:09
 * @description 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 309. 最佳买卖股票时机含冷冻期
 **/
public class maxProfit5_ {
    public int maxProfit(int[] prices) {
        /**
         * 几种状态:
         * 持有股票:
         *      今天买入股票或者之前买入股票但未操作----0
         * 未持有股票:
         *      今天刚卖掉----1
         *      昨天刚卖掉,今天处于冷冻期----2
         *      昨天也没有持有股票,今天不是冷冻期----3
         */
        //dp[i][0]=dp[i-1][0]或dp[i-1][2]-prices[i]或dp[i-1][3]-prices[i](昨天持有股票,今天不买; 昨天没有持有股票,且不处于冷冻期,今天买入股票; 昨天处于冷冻期,今天买入)
        //dp[i][1]=dp[i-1][0]+prices[i](昨天持有股票,今天刚卖掉)
        //dp[i][2]=dp[i-1][1](昨天刚卖掉)
        //dp[i][3]=dp[i-1][3]或者dp[i-1][2](昨天要么也是未持有且不处于冷冻期要么就是处于冷冻期)
        int[][]dp=new int[prices.length+1][4];
        dp[1][0]=-prices[0];
        dp[1][1]=0;
        dp[1][2]=0;
        dp[1][3]=0;
        for (int i = 2; i <=prices.length ; i++) {
            dp[i][0]=max(dp[i-1][0],dp[i-1][2]-prices[i-1],dp[i-1][3]-prices[i-1]);
            dp[i][1]=dp[i-1][0]+prices[i-1];
            dp[i][2]=dp[i-1][1];
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]);
        }
        return max(dp[prices.length][1],dp[prices.length][2],dp[prices.length][3]);
    }

    public int max(int a,int b,int c){
        if(a>=b){
            if(a>=c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b>=c){
                return b;
            }else{
                return c;
            }
        }
    }

}
