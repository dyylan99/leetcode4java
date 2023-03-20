package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/15 11:06
 * @description TODO
 * 剑指 Offer 03. 数组中重复的数字
 **/
public class findRepeatNumber_ {
    public int findRepeatNumber(int[] nums) {
        int n=nums.length;

        for (int i = 0; i < n; i++) {
            int t=Math.abs(nums[i]);
            if(t==nums.length){
                t=0;
            }
            if(nums[t]<0){
                return Math.abs(nums[i]);
            }else{
                nums[t]=nums[t]==0?-n:-nums[t];
            }
        }
        return 0;
    }
}
