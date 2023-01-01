package DynamicPrograming;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/15 14:57
 * @description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 416. 分割等和子集
 **/
public class canPartition_ {
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int n=nums.length;
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }

        int target=sum/2;
        int[]dp=new int[target+1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j>=nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }

    @Test
    public void test(){
        System.out.println(canPartition(new int[]{1, 3, 5, 7, 6}));
    }
}
