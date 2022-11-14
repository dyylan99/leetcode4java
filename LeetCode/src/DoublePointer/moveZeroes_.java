package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/14 13:35
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *283. 移动零
 **/
public class moveZeroes_ {
    //双指针法
    public void moveZeroes(int[] nums) {
        int val=0;
        int slowIndex=0;
        for (int fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        for (int i = slowIndex; i <nums.length ; i++) {
            nums[i]=0;
        }
    }
}
