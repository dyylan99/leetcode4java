package cn.dylan.Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 16:14
 * @description TODO
 * 3 4 2 1 4 3 2 1
 * 4 1 2 3
 **/
public class nextPermutation_ {
    public void nextPermutation(int[] nums) {
        if (nums.length<=1){
            return;
        }
        for (int i = nums.length-1; i>=0; i--) {
            for (int j = nums.length-1; j>i; j--) {
                if (nums[j]>nums[i]){
                    swap(nums,i,j);
                    reverse(nums,i+1,nums.length-1);
                    return;
                }
            }
        }
        reverse(nums,0,nums.length-1);
    }
    private void swap(int[] nums, int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void reverse(int[] nums, int l, int r){
        while (l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

}
