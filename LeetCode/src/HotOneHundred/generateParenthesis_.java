package HotOneHundred;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/28 10:09
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 *
 * 22. 括号生成
 **/
public class generateParenthesis_ {
    List<String>res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTracking(n,0,0);
        return res;
    }

    //count记录当前s中含有多少左括号
    public void backTracking(int n,int count,int close){
        if(sb.length()==n*2){
            if(isValid(sb.toString())){
                res.add(sb.toString());
            }else{
                return;
            }
        }
            if (count<n){
                sb.append("(");
                count++;
                backTracking(n,count,close);
                sb.deleteCharAt(sb.length()-1);
                count--;
            }
            if(close<count) {
                sb.append(")");
                close++;
                backTracking(n, count,close);
                sb.deleteCharAt(sb.length() - 1);
                close--;
            }

    }

    public boolean isValid(String s){
        int n=0;
        if(s==null){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                n++;
            }else{
                if(n<1){
                    return false;
                }
                n--;
            }
        }
        return n==0;
    }

    @Test
    public void test(){
        System.out.println(isValid("()(())"));
    }
}
