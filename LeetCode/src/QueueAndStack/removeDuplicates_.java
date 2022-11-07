package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/7 15:00
 * @description 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 1047. 删除字符串中的所有相邻重复项
 **/
public class removeDuplicates_ {
    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }
    //使用栈解决
    public static String removeDuplicates(String s) {
        Stack<Character>st=new Stack<>();
        int len=s.length();
        st.push(s.charAt(0));
        int i=1;
        while (i<len) {
           if(st.empty() || s.charAt(i)!=st.peek()){
               st.push(s.charAt(i));
           }else{
               st.pop();
           }
           i++;
        }
        StringBuffer res=new StringBuffer("");
        while (!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }

    //使用arrayDeque作为堆栈
    public static String removeDuplicates1(String s) {
        ArrayDeque<Character> deque=new ArrayDeque<>();
        int len=s.length();
        deque.push(s.charAt(0));
        int i=1;
        while (i<len) {
            if(deque.isEmpty() || s.charAt(i)!=deque.peek()){
                deque.push(s.charAt(i));
            }else{
                deque.pop();
            }
            i++;
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }

}
