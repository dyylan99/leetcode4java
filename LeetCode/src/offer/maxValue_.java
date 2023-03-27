package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/24 15:08
 * @description 剑指 Offer 47. 礼物的最大价值
 **/
public class maxValue_ {
    public int maxValue(int[][] grid) {
        /**
         * dfs超时
         */
        /**
         * dp[i]为从(0,0)到每一行第i列的最大值
         * 则dp[i]就为dp[i]和dp[i-1]的最大值加上当前行当前列的值
         */
        int[]dp=new int[grid.length+1];

        //dp[0]=grid[0][0];
        for (int[] ints : grid) {
            for (int i = 0; i < ints.length; i++) {
                dp[i+1]=Math.max(dp[i+1],dp[i])+ints[i];
            }
        }
        return dp[grid.length];
    }

}
