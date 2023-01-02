package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/2 12:53
 * @description 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 *
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 *  674. 最长连续递增序列
 **/
public class findLengthOfLCIS_ {
    public int findLengthOfLCIS(int[] nums) {
        /**
         * dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
         * 如果 nums[i] > nums[i - 1]，那么以 i 为结尾的连续递增的子序列长度 一定等于 以i - 1为结尾的连续递增的子序列长度 + 1 。
         */
        int[]dp=new int[nums.length];
        int res=1;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            if(dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }
}
