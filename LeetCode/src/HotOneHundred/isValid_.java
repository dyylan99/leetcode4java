package HotOneHundred;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/27 11:44
 * @description
 *
 * 20. 有效的括号
 **/
public class isValid_ {
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i)==')'){
                    if(!stack.empty()&&stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(!stack.empty()&&stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    if(!stack.empty()&&stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
