package QueueAndStack;

import org.junit.Test;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/7 15:54
 * @description 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意 两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 150. 逆波兰表达式求值
 **/
public class evalRPN_ {

    @Test
    public void test(){
        //String[]tokens={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        //System.out.println(evalRPN(tokens));
        String s="-000025.3";
        System.out.println(s.matches("-?[0-9]+.?[0-9]*"));
    }


    private static Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");
    public  int evalRPN(String[] tokens) {
        Stack<String>s=new Stack<>();
        s.push(tokens[0]);
        int num=Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            if(pattern.matcher(tokens[i]).matches()){
                s.push(tokens[i]);
            }else{
                String s2=s.pop();
                String s1=s.pop();
                 num= getRes(s1, s2, tokens[i]);
                s.push(Integer.toString(num));
            }
        }
        return num;
    }
    //字符串运算函数
    public int getRes(String s1,String s2,String s3){
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        if("+".equals(s3)){
            return num1+num2;
        }else if("-".equals(s3)){
            return num1-num2;
        }else if("*".equals(s3)){
            return num1*num2;
        }else{
            return num1/num2;
        }
    }
}
