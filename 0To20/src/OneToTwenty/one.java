package OneToTwenty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/6 21:54
 * @description 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 **/
public class one {
    /**
     *
     *解题思路:首先常规解法是套用两次for循环暴力求解,但是时间复杂度为O(n^2)
     * 而时间复杂度最低的算法是,
     * 使用遍历给定的数组,
     * 使用map容器装配数据,key是target-nums[i], value则是i
     * 这样就可以将数组中每个元素关于目标数的差数得到并且放在map容器中,
     * 此时再在遍历数组的同时查看集合的key包不包括数组遍历的元素
     * 若包括,则证明该数组元素关于目标数的差数已经在之前遍历的数组中,并且其下标就是map.get(nums[i])
     * 这样就可以找出target的两个和数
     * 时间复杂度为o(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        int index[] = new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< nums.length;i++)
        {
            if(map.containsKey(nums[i])){
                index[0]=i;
                index[1]=map.get(nums[i]);
                return index;
            }
            map.put(target-nums[i],i);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 5, 8, 9, 6}, 15);
        System.out.println(""+ints[0]+"   "+ints[1]);
    }
}
