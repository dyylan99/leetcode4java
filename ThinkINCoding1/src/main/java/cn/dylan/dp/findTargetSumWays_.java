package cn.dylan.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/17 13:19
 * @description 494. 目标和
 **/
public class findTargetSumWays_ {
    //public int findTargetSumWays1(int[] nums, int target) {
    //    //假设加法总和是x, 那么减法的绝对值和为: sum-x 因此 x-(sum-x)=target ---> x=(sum+target)/2;
    //    int sum=0;
    //    for (int num : nums) {
    //        sum+=num;
    //    }
    //    if (target>sum){
    //        return 0;
    //    }
    //    int x=(sum+target)/2;
    //    if (x%2==1){
    //        return 0;
    //    }
    //    int[]dp=new int[x+1];
    //    dp[0]=1;
    //    for (int i = 0; i < nums.length; i++) {
    //        for (int j = x; j>=nums[i] ; j--) {
    //            dp[j]+=dp[j-nums[i]];
    //        }
    //    }
    //    return dp[x];
    //}
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums,target,0,0);
        return count;
    }

    private void backTracking(int[]nums, int target, int cur,int sum){
       if (cur==nums.length){
           if (sum==target){
               count++;
               return;
           }
       }else{
           backTracking(nums,target,cur+1,sum+nums[cur]);
           backTracking(nums,target,cur+1,sum-nums[cur]);
       }
    }

}
