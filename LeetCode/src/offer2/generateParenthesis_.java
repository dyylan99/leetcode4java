package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/10 14:45
 * @description TODO
 **/
public class generateParenthesis_ {
    public StringBuilder sb=new StringBuilder();
    public List<String>res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTracking(n,0,0);
        return res;
    }

    public void backTracking(int n,int leftCount,int rightCount){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(leftCount<n){
            sb.append("(");
            backTracking(n,leftCount+1,rightCount);
            sb.deleteCharAt(sb.length()-1);
        }
        if (rightCount<leftCount){
            sb.append(")");
            backTracking(n,leftCount,rightCount+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
