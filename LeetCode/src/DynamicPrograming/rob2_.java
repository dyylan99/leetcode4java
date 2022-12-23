package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/20 16:19
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 *
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 **/
public class rob2_ {
    public int rob(int[] nums) {
        /**
         * 分三种情况, 一:不包含首尾元素
         *
         * 二: 包含首元素,不包含尾元素
         *
         * 三: 包含尾元素,不包含首元素
         *
         * 但是情况二和情况三都包含了一,只要考虑后两种就行
         */

        int size=nums.length;
        if(size==1){
            return nums[0];
        }
        //情况二:
        int res1=rob_(nums,0,size-2);
        int res2=rob_(nums,1,size-1);
        return Math.max(res1,res2);
    }
    //start和end都是包含的
    public int rob_(int[]nums,int start, int end){
       if(start==end){
           return nums[start];
       }
        int[]dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start+1],dp[start]);
        for (int i = start+2; i <=end; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[end];
    }
}
