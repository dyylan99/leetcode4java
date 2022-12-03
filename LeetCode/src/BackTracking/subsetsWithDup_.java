package BackTracking;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/3 13:59
 * @description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 90. 子集 II
 **/

public class subsetsWithDup_ {
    List<List<Integer>>res=new ArrayList<>();

    LinkedList<Integer>path=new LinkedList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums,0);
        return res;
    }

    void backTracking(int[] nums,int startIndex){
        if(startIndex>=nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i>startIndex&&nums[i]==nums[i-1]){
                continue;
            }
           path.add(nums[i]);
           backTracking(nums,i+1);
           path.removeLast();
        }


    }

}
