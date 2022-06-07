package SearchAndSort;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/4 12:18
 * @description 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 * /**
 * 建议使用的方法为:二分查找法(利用升序的特性)
 * step 1：从数组首尾开始，每次取中点值。
 * step 2：如果中间值等于目标即找到了，可返回下标，如果中点值大于目标，说明中点以后的都大于目标，因此目标在中点左半区间，如果中点值小于目标，则相反。
 * step 3：根据比较进入对应的区间，直到区间左右端相遇，意味着没有找到。
 **/
public class One {
    public int search (int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }

}
