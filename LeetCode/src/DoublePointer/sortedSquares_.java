package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/14 14:31
 * @description 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 977. 有序数组的平方
 **/
public class sortedSquares_ {
    public int[] sortedSquares(int[] nums) {
        if(nums[0]>=0){
            for (int i = 0; i < nums.length; i++) {
                nums[i]=nums[i]*nums[i];
            }
            return nums;
        }
        int[] arr =new int[nums.length];
        int l=0;
        int r=nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if(nums[l]*nums[l]>nums[r]*nums[r]){
                arr[i]=nums[l]*nums[l];
                l++;
            }else{
                arr[i]=nums[r]*nums[r];
                r--;
            }
        }
        return arr;
    }
}
