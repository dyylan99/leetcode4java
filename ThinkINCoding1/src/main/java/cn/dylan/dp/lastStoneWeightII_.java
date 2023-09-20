package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/17 13:14
 * @description 1049. 最后一块石头的重量 II
 **/
public class lastStoneWeightII_ {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int stone : stones) {
            sum+=stone;
        }
        int target=sum/2;
        int[]dp=new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j>=stones[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }
}
