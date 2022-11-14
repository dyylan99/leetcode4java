package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/13 18:20
 * @description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 27. 移除元素
 **/
public class removeElement_ {
    //双指针法

    /**
     *
     * @param nums
     * @param val
     * @return nums.length
     * 慢指针记录新数组装载的元素,快指针遍历
     */
    public int removeElement(int[] nums, int val) {
     int slowIndex=0;
     for (int fastIndex=0;fastIndex<nums.length;fastIndex++){
         if(nums[fastIndex]!=val){
             nums[slowIndex]=nums[fastIndex];
             slowIndex++;
         }
     }
     return slowIndex;
    }
}
