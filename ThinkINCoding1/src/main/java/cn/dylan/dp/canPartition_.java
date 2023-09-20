package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/17 13:08
 * @description 416. 分割等和子集
 **/
public class canPartition_ {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int target=sum/2;
        //dp[j]是背包容量为j时能装下的最大的价值数
        int[]dp=new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j>=nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;

    }
}
