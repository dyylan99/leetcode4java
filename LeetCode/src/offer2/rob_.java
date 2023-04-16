package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/16 16:31
 * @description 剑指 Offer II 090. 环形房屋偷盗
 **/
public class rob_ {

    int[]nums;
    public int rob(int[] nums) {
        this.nums=nums;
        int len=nums.length;
        if (len==1){
            return nums[0];
        }
        if (len==2){
            return Math.max(nums[1],nums[0]);
        }
        return Math.max(dpHelper(0,len-2),dpHelper(1,len-1));
    }

    private int dpHelper(int start,int end){
        //dp[i]代表从[0,i]间房屋能获得的最大收益
        int []dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <=end ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
