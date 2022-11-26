package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/26 13:20
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 35. 搜索插入位置
 **/
public class searchInsert_ {
    //0,1,3,4,5       2           middle=2    middle=0

    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle=0;
        while (left<=right){
             middle=(left+right)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else{
                return middle;
            }
        }
       return right+1;
    }
}
