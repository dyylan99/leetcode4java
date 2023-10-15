package cn.dylan.stack;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/1 15:49
 * @description 20. 有效的括号
 **/
public class isValid_ {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character>stack=new Stack<>();
        for (char c : charArray) {
            if (c=='(' ||c=='{' || c=='['){
                stack.push(c);
            } else if (c==')') {
                if (stack.isEmpty() || stack.peek()!='('){
                    return false;
                }
                stack.pop();
            }else if (c==']') {
                if (stack.isEmpty() || stack.peek()!='['){
                    return false;
                }
                stack.pop();
            }else if (c=='}') {
                if (stack.isEmpty() || stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
