package cn.dylan.backTracking;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/13 14:57
 * @description 40. 组合总和 II
 **/
public class combinationSum2_ {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates,target,0,0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int cur, int sum){
        if (sum==target){
            res.add(new ArrayList<>(path));
        }

        for (int i = cur; i < candidates.length; i++) {
            if (sum+candidates[i]>target){
                break;
            }
            if (i>cur && candidates[i]==candidates[i-1]){
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            backTracking(candidates,target,i+1,sum);
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }

}
