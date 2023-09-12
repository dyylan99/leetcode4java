package cn.dylan.Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/6/19 18:36
 * @description 26. 删除有序数组中的重复项
 **/
public class removeDuplicates_ {
    public int removeDuplicates(int[] nums){
        //双指针法
        int slow=1;
        int val=nums[0];
        for (int fast = 1; fast <nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
                val=nums[fast];
            }
        }
        return slow;

    }
}
