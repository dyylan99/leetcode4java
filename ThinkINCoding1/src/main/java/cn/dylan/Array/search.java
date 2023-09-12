package cn.dylan.Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/6/1 23:23
 * @description 代码随想录二刷: 数组模块: 1.二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 **/
public class search {
    public int search_(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(right-left)/2+left;
            if (nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

    }
}
