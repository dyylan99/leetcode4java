package cn.dylan.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/13 15:18
 * @description 46. 全排列
 **/
public class permute_ {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length==0){
            return result;
        }
        used=new boolean[nums.length];
        backTracking(nums);
        return result;
    }

    private void backTracking(int []nums){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backTracking(nums);
            used[i]=false;
            path.removeLast();
        }
    }
}
