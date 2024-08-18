package ArrayTrain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/30 22:58
 * @description TODO
 **/
public class subarraySum_ {
    public int subarraySum(int[] nums, int k) {
        //map定义为前缀和为key,前缀和出现的次数为value
        Map<Integer,Integer>map=new HashMap<>();
        //首个元素的前缀和为0,出现次数为1
        map.put(0,1);
        int res=0;
        int preSum=0;
        for (int num : nums) {
            preSum+=num;
            //如果map中出现过preSum-k,则说明存在子数组的和为k
            if (map.containsKey(preSum-k)){
                res+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return res;
    }
}
