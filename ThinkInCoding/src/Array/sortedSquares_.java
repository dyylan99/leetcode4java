package Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/7/14 16:30
 * @description 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序 排序。
 *
 **/
public class sortedSquares_ {
    public int[] sortedSquares(int[] nums) {
        /**
         * 思路:
         * 仍然是双指针的方法: 将原数组全部平方过后, 左指针指向左边界, 右指针指向右边界, 相互比较, 大的放入结果数组中
         */
        int length=nums.length;
        int []res=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int position=right;
        while (right>=left){
            if (nums[right]*nums[right]>nums[left]*nums[left]){
                res[position]=nums[right]*nums[right];
                right--;
            }else{
                res[position]=nums[left]*nums[left];
                left++;
            }
            position--;
        }
        return res;
    }
}
