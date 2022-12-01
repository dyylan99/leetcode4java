package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/1 14:04
 * @description 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 *
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *39. 组合总和
 **/
public class combinationSum_ {
    private List<List<Integer>>res=new ArrayList<>();

    private LinkedList<Integer>path=new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        return res;
    }

    public void backTrack(int[] candidates,int target,int sum,int startIndex){
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<candidates.length&&sum+candidates[i]<=target;i++){
            sum+=candidates[i];

            path.add(candidates[i]);
            //之所以是i,是因为可以重复选取元素
            backTrack(candidates,target,sum,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
