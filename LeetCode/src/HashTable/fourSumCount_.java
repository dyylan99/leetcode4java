package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/24 12:42
 * @description 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *454. 四数相加 II
 **/
public class fourSumCount_ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer>map=new HashMap<>();
        int res=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int i1 : nums2) {
                Integer count = map.getOrDefault(nums1[i] + i1, 0);
                map.put(nums1[i]+i1,count+1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int i1 : nums4) {
                Integer count = map.getOrDefault(-nums3[i] - i1, 0);
                res+=count;
            }
        }
        return res;
    }
}
