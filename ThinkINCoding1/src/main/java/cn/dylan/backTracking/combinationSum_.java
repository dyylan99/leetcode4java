package cn.dylan.backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/13 14:28
 * @description 39. 组合总和
 **/
public class combinationSum_ {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0]>target){
            return res;
        }
        backTracking(candidates,target,0);
        return res;
    }

    private void backTracking(int[]candidates, int target, int cur){
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum>target){
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            sum+=candidates[i];
            path.add(candidates[i]);
            backTracking(candidates,target,i);
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
