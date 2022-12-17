package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/17 14:40
 * @description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 322. 零钱兑换
 **/
public class coinChange_ {
    //完全背包加上组合数问题
    //dp[j]表示从硬币数组中凑成数额为j的最小硬币数
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[]dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
