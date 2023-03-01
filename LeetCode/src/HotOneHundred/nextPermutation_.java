package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/1 8:52
 * @description 31. 下一个排列
 **/
public class nextPermutation_ {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i>=0; i--) {
            for (int j = nums.length-1; j>i ; j--) {
                if(nums[j]>nums[i]){
                    int tem=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tem;
                    reverse(nums,i+1,nums.length-1);
                    return;
                }
            }
        }
        //否则如果数组是倒序的话,直接反转整个数组
        reverse(nums,0,nums.length-1);
    }

    //反转指定位置的数组
    public void reverse(int[] arr,int start,int end){
        for (int i = start,j=end; i<=j ; i++,j--) {
            int tem=arr[i];
            arr[i]=arr[j];
            arr[j]=tem;
        }
    }
}
