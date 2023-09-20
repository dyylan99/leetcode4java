package cn.dylan.dp;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/18 15:09
 * @description TODO
 **/
public class lengthOfLIS_ {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int res=1;
        int dp[]=new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
