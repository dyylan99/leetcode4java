package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/30 12:49
 * @description 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 216. 组合总和 III
 **/
public class combinationSum3_ {
    LinkedList<Integer>path=new LinkedList<>();
    List<List<Integer>>res=new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1,0);
        return res;
    }

    void backTracking(int n,int k,int startIndex,int sum){
        //剪枝操作
        if (sum>n){
            return;
        }
        if(path.size()==k){
            if(sum==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        //9-(k-path.size())+1   9是可选数字区间,k是需要区间的长度,path.size()则是已近取出的区间长度,+1是因为从下一个数字开始
        for (int i=startIndex;i<=9-(k-path.size())+1;i++){
            sum+=i;
            path.add(i);
            backTracking(n,k,i+1,sum);
            //回溯
            sum-=i;
            path.removeLast();
        }

    }
}
