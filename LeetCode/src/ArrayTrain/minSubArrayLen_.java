package ArrayTrain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/27 19:18
 * @description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *209. 长度最小的子数组
 **/

public class minSubArrayLen_ {
    /**
     *
     * @param target
     * @param nums
     * 滑动窗口:
     * 小则则加,大则去掉左边
     *
     * 看似滑动窗口,实则暴力解法
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int res=0;
        int length=nums.length;
        for (int i = 0; i < length; i++) {
            int j=i;
            int sum=0;
            while (true){
               if(sum<target&&j<length){
                   sum+=nums[j];
                   j++;
               }else if(sum>=target&&j<=length){
                   if (res==0||res>j-i){
                       res=j-i;
                   }
                   break;
               }else{
                   return res;
               }
            }
        }
        return res;
    }


    //滑动窗口优化版本
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int length=nums.length;
        int left=0;
        int sum=0;
        for (int right = 0; right < length; right++) {
            sum+=nums[right];
            while (sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }





    @Test
    public void test(){
        int i = minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
}
