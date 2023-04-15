package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/11 21:02
 * @description TODO
 **/
public class subarraySum_ {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();

        int count=0;
        map.put(0,1);
        int preSum=0;
        for (int num : nums) {
            preSum+=num;
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
    //易懂版本:
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
