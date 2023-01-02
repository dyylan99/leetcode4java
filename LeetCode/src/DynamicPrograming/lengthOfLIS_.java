package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/2 12:44
 * @description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序
 * 。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 300. 最长递增子序列
 **/
public class lengthOfLIS_ {
    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
         */
        if (nums.length<=1){
            return nums.length;
        }
        int[]dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }
}
