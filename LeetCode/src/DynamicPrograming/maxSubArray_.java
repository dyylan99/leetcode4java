package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/3 16:00
 * @description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 53. 最大子数组和
 **/
public class maxSubArray_ {
    public int maxSubArray(int[] nums) {
        //dp[i]为包括下标i的最大子序列的和,因此dp[i]可能不是[0,i-1]中最大的和,但是dp肯定会记录到最大的和
        //dp[i]只能为dp[i-1]+nums[i]或者nums[i]
        int res=nums[0];
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }
}
