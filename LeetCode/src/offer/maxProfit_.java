package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 17:09
 * @description 剑指 Offer 63. 股票的最大利润
 **/
public class maxProfit_ {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[]dp=new int[2];
        //持有股票dp[1]最大现金流
        //未持有股票dp[0]最大现金流
        //则 dp[0]=max(0,prices[i]+dp[1])
        dp[0]=0;
        dp[1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0]=Math.max(dp[1]+prices[i],dp[0]);
            dp[1]=Math.max(-prices[i],dp[1]);
        }
        return dp[0];
    }
}
