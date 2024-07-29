package cn.dylan.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/15 14:23
 * @description TODO
 **/
public class generateParenthesis_ {
    List<String>res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTracking(n,0,0);
        return res;
    }

    private void backTracking(int n,int left,int right){
        if (right>left)return;
        if (left==right && left==n){
            res.add(sb.toString());
            return;
        }
        if (left<n){
            sb.append('(');
            backTracking(n,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (left>right){
            sb.append(')');
            backTracking(n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
