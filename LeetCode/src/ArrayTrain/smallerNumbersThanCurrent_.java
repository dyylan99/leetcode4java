package ArrayTrain;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/19 12:12
 * @description 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 * 1365. 有多少小于当前数字的数字
 **/
public class smallerNumbersThanCurrent_ {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        int[] hash=new int[101];
        for (int i = nums.length-1; i>=0 ; i--) {
            hash[nums1[i]]=i;
        }
        int []res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i]=hash[nums[i]];
        }
        return res;
    }
}
