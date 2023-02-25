package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/25 10:42
 * @description 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 *
 * 注意 这个数列必须是 严格 递增的。
 *
 * 673. 最长递增子序列的个数
 **/
public class findNumberOfLIS_ {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        //dp[i]为[0,i]范围内最长递增子序列的长度
        //count[i]为最长递增子序列的个数
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxCount=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
               if(nums[i]>nums[j]){
                   if((dp[j]+1)>dp[i]){
                       dp[i]=dp[j]+1;
                       count[i]=count[j];
                   }else if(dp[j]+1==dp[i]){
                       count[i]+=count[j];
                   }
               }
               if(dp[i]>maxCount){
                   maxCount=dp[i];
               }
            }
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if(maxCount==dp[i]){
                res+=count[i];
            }
        }
       return res;
    }
}
