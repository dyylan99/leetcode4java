package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/18 12:33
 * @description 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 **/
public class nextGreaterElements_ {
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int[]nums2=new int[2*len];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=nums[i%len];
        }
        int[]res=new int[len];
        Arrays.fill(res,-1);
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <nums2.length ; j++) {
                if(nums2[j]>nums[i]){
                    res[i]=nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
