package HotOneHundred;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/11 13:28
 * @description 394. 字符串解码
 **/
public class decodeString_ {

    //双栈法
    public String decodeString(String s) {
        Stack<Integer>stack1=new Stack<>();
        Stack<StringBuilder>stack2=new Stack<>();

        int tNum=0;
        int i=0;
        StringBuilder sb=new StringBuilder();

        while (i<s.length()){
            char c = s.charAt(i++);
            if(c=='['){
                stack1.add(tNum);
                stack2.add(sb);
                tNum=0;
                sb=new StringBuilder();
            }else if(c==']'){
                StringBuilder stringBuilder = stack2.pop();
                Integer integer = stack1.pop();
                for (Integer i1 = 0; i1 < integer; i1++) {
                    stringBuilder.append(sb.toString());
                }
                sb=stringBuilder;
            }else if('0'<=c&&c<='9'){
                tNum=tNum*10+c-'0';
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(decodeString("3[a2[c]]"));
    }
}
