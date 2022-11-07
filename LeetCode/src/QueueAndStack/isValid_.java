package QueueAndStack;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/1 16:16
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 20. 有效的括号
 **/
public class isValid_ {
    public boolean isValid(String s) {
        int size=s.length();
        if(size%2!=0){
            //若字符串长度为负数,则一定不符合要求
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < size; i++) {
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if (s.charAt(i)=='['){
                stack.push(']');
            }else if (stack.empty()||stack.peek()!=s.charAt(i)){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.empty();
    }
}
