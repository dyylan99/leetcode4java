package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/1 14:22
 * @description 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 40. 组合总和 II
 **/
public class combinationSum2_ {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        backTracking(candidates,target,res,new LinkedList<>(),0,0);
        return res;
    }

    public void backTracking(int[] candidates, int target, List<List<Integer>>res, LinkedList<Integer> path, int sum, int startIndex){
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<candidates.length&&sum+candidates[i]<=target;i++){
            //跳过重复元素
            if ( i > startIndex && candidates[i] == candidates[i - 1] ) {
                continue;
            }
                sum+=candidates[i];
                path.add(candidates[i]);
                backTracking(candidates,target,res,path,sum,i+1);
                sum-=candidates[i];
                path.removeLast();
        }
    }
}
