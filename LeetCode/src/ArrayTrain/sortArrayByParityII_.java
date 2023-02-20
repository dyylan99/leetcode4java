package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/20 11:17
 * @description 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 *
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 *
 * 你可以返回 任何满足上述条件的数组作为答案
 *
 * 922. 按奇偶排序数组 II
 **/
public class sortArrayByParityII_ {
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex=1;
        for (int i = 0; i < nums.length; i+=2) {
            if(nums[i]%2==1){
                //偶数位置找到了奇数
                //需要从奇数位置找一个偶数替换
                while (nums[oddIndex]%2!=0){
                    oddIndex+=2;
                }
                nums[i]=nums[i]^nums[oddIndex];
                nums[oddIndex]=nums[i]^nums[oddIndex];
                nums[i]=nums[i]^nums[oddIndex];
            }
        }
        return nums;
    }

}
