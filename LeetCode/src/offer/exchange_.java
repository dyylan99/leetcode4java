package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/18 12:21
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 *
 *
 **/
public class exchange_ {
    public int[] exchange(int[] nums) {
        //双指针,前奇后偶
        if(nums.length==0||nums.length==1){
            return nums;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            if(nums[left]%2==1){
                left++;
            }else if(nums[right]%2==0){
                //left所在位置为偶数,right所在位置为奇数
                //那就交换
                int tem=nums[left];
                nums[left]=nums[right];
                nums[right]=tem;
                left++;
                right--;
            }else{
                //如果left和right都为偶数,那么就让right找到奇数位置
                while (right>left&&nums[right]%2==0){
                    right--;
                }
                if(right>left){
                    int tem=nums[left];
                    nums[left]=nums[right];
                    nums[right]=tem;
                    left++;
                    right--;
                }else{
                    return nums;
                }
            }
        }
        return nums;
    }
}
