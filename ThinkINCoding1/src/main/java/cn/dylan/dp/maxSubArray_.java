package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 15:27
 * @description 53. 最大子数组和
 **/
public class maxSubArray_ {
    public int maxSubArray(int[] nums) {
        //dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
        //则: dp[i]=max(nums[i],dp[i-1]+nums[i])
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            res=Math.max(res,dp[i]);
        }

        return res;

    }
}
