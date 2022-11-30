package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/30 12:27
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 77.组合
 **/
public class combine_ {
    private List<List<Integer>>res=new ArrayList<>();
    private LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }

    void backTracking(int n,int k,int startIndex){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=n-(k-path.size())+1;i++){
            path.add(i);
            backTracking(n,k,i+1);
            path.removeLast();
        }
    }
}
