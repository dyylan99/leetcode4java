package offer;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/27 16:13
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 **/
public class search1 {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        /**
         * 二分法统计
         */
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        int count=0;
        while (left<=right){
            if(target<nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                //找到了目标数
                left=mid;
                right=mid+1;
                while (left>=0&&nums[left]==target){
                    count++;
                    left--;
                }
                while (right<nums.length&&nums[right]==target){
                    count++;
                    right++;
                }
                return count;
            }
            mid=left+(right-left)/2;
        }
        return 0;
    }
    @Test
    public void test(){
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
