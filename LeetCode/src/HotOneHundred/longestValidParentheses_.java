package HotOneHundred;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/1 9:16
 * @description 32. 最长有效括号
 **/
public class longestValidParentheses_ {
    //(()(()
    public int longestValidParentheses(String s) {
       //用栈做匹配,不匹配的字符标记为1,匹配的标记为0
        if(s.length()==0||s.length()==1){
            return 0;
        }
        int res=0;
        Stack<Integer>st=new Stack<>();
        int[]mark=new int[s.length()];
        for (int i = 0; i < mark.length; i++) {
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                if(st.empty()){
                    mark[i]=1;
                }else{
                    st.pop();
                }
            }
        }
        while (!st.empty()){
            //多余的左括号
            mark[st.pop()]=1;
        }
        //求数组的最长连续0
        int tem=0;
        for (int i = 0; i < mark.length; i++) {
            if(mark[i]==0){
                tem++;
            }else{
                res=Math.max(res,tem);
                tem=0;
            }
        }
        return Math.max(res,tem);
    }
    @Test
    public void test(){
        System.out.println(longestValidParentheses("(()"));
    }
}
