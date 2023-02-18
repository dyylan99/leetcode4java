package MonotonicStack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/18 11:47
 * @description nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 *
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素
 **/
public class nextGreaterElement_ {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]res=new int[nums1.length];
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer index2 = map.get(nums1[i]);
            int num = findNum(index2, nums2, nums1[i]);
            res[i]=num;
        }
        return res;
    }

    public int findNum(int index,int[] nums,int num){
        int res=-1;
        for (int i = index+1; i < nums.length; i++) {
            if(nums[i]>num){
                res=nums[i];
                break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[]nums1=new int[]{4,1,2};
        int[]nums2=new int[]{1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
