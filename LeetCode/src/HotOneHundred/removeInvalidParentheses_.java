package HotOneHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/11 12:23
 * @description 301. 删除无效的括号
 **/
public class removeInvalidParentheses_ {

    List<String>res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lremove=0,rremove=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                lremove++;
            }else if(s.charAt(i)==')'){
                if(lremove==0){
                    rremove++;
                }else{
                    lremove--;
                }
            }
        }
        backtracking(s,0,lremove,rremove);
        return res;
    }


    public void backtracking(String state,int start,int lremove,int rremove){
        if(lremove==0&&rremove==0){
            if(isValid(state)){
                res.add(state);
            }
            return;
        }
        for (int i = start; i < state.length(); i++) {
            //去重
            if(i!=start&&state.charAt(i)==state.charAt(i-1)){
                continue;
            }
            //需要去除的括号数量大于剩余的字符数量,则直接返回
            if(rremove+lremove>state.length()-i){
                return;
            }
            //去除一个左括号
            String state1 = state.substring(0, i) + state.substring(i + 1);
            if(lremove>0&&state.charAt(i)=='('){
                backtracking(state1,i,lremove-1,rremove);
            }
            //去除一个右括号
            if(rremove>0&&state.charAt(i)==')'){
                backtracking(state1,i,lremove,rremove-1);
            }
        }


    }

    private boolean isValid(String s){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                count++;
            }else if(s.charAt(i)==')'){
                if(count==0){
                    return false;
                }else{
                    count--;
                }
            }
        }
        return count==0;
    }

}
