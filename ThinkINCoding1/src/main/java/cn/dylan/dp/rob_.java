package cn.dylan.dp;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/20 16:10
 * @description 198. 打家劫舍
 **/
public class rob_ {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        //dp[i]有下标为i的这些房屋所得的最大收益
        //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1])
        int[]dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        dp[2]=Math.max(dp[1],nums[1]);
        for (int i = 3; i <=nums.length ; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }
}
