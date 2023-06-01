package Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/6/1 23:30
 * @description 代码随想录二刷: 数组: 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 **/
public class searchInsert_ {
    public int searchInsert(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return right+1;
    }
}
