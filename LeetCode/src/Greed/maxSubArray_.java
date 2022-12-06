package Greed;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/6 14:32
 * @description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 53. 最大子数组和
 **/
public class maxSubArray_ {

    public int maxSubArray(int[] nums) {
        //贪心算法,不断调整起始位置
        int result=Integer.MIN_VALUE;
        int tem=0;
        for (int i=0;i<nums.length;i++){
           tem+=nums[i];
           if(tem>result){
               result=tem;
           }
           if(tem<=0){
               tem=0;
           }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
