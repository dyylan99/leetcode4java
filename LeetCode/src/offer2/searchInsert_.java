package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 15:01
 * @description TODO
 **/
public class searchInsert_ {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while (left<=right){
            if (target>nums[mid]){
                left=mid+1;
            }else if (target< nums[mid]){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
