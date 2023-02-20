package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/20 10:43
 * @description 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 189. 轮转数组
 **/
public class rotate_ {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        //第一步:先反转整个数组
        reverse(nums,0,nums.length-1);
        //第二步:反转前k个:
        reverse(nums,0,k-1);
        //反转后nums.length-k个
        reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums,int start, int end){
        for (int i = start,j=end; i <j ; i++,j--) {
            int tem=nums[j];
            nums[j]=nums[i];
            nums[i]=tem;
        }
    }
}
