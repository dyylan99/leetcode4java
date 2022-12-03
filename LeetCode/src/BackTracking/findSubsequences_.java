package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/3 14:23
 * @description 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 491. 递增子序列
 **/
public class findSubsequences_ {

    List<List<Integer>>res=new ArrayList<>();

    LinkedList<Integer>path=new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    void backTracking(int[] nums,int startIndex){
        if(path.size()>1){
            res.add(new ArrayList<>(path));
        }
        if(startIndex>=nums.length){
            return;
        }
        int[]used=new int[100];   //做hash映射去重
        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty()&&nums[i]<path.getLast()||(used[nums[i]+100]==1)){
                continue;
            }
            used[nums[i]+100]=1;
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
        }
    }
}
