package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 19:05
 **/
public class SExpress {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /**
         * 字符串格式:
         *  左右括号两边无空格,参数之间用空格隔开
         * (操作符 参数1 参数2 参数n)
         */
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(res(str));
        }
    }

    /**
     *
     * @param str
     * @return
     * 根据表达式字符串计算结果
     */
    public static int res(String str){
        //使用栈辅助计算
        Stack<String>stack=new Stack<>();
        int res=0;
        char[] chars = str.toCharArray();
        int length = chars.length;
        int index=0;
        while (index<length){
            char aChar=chars[index];
            if(aChar=='+'||aChar=='-'||aChar=='*'){
                //遍历到运算符就入栈
                stack.push(String.valueOf(aChar));
                index++;
            }else if(aChar=='('){
                //左括号直接跳过
                index++;
            }else if(aChar==')'){
                //右括号就从栈中弹出元素,直到弹出第一个运算符为止
                List<Integer>list=new ArrayList<>();
                while (!stack.peek().equals("-")&&!stack.peek().equals("+")&&!stack.peek().equals("*")){
                    list.add(Integer.parseInt(stack.pop()));
                }
                //为了拿到正确的运算顺序("-"操作符对顺序有要求),反转list
                reverse(list);
                //拿到运算符
                String s = stack.pop();
                //计算一个括号内的结果
                res=getNum(s,list);
                //新结果入栈
                stack.push(String.valueOf(res));
                index++;
            } else if(aChar-'0'>=0&&aChar-'9'<=0){
                //遍历数字,需要拿到完整数字入栈
                StringBuilder num= new StringBuilder();
                while (aChar-'0'>=0&&aChar-'9'<=0){
                    num.append(aChar);
                    index++;
                    aChar=chars[index];
                }
                //数字入栈
                stack.push(num.toString());
            }else {
                //遍历到其他符号(空格)跳过
                index++;
            }
        }
        return res;
    }

    /**
     *
     * @param s(操作符)
     * @param list(参数列表)
     * @return 返回操作结果
     */
    public static int getNum(String s,List<Integer>list){
        int res=list.get(0);
        if(s.equals("*")){
            for (int i = 1; i <list.size() ; i++) {
                res*=list.get(i);
            }
        }else if(s.equals("-")){
            for (int i = 1; i <list.size() ; i++) {
                res-=list.get(i);
            }
        }else{
            for (int i = 1; i <list.size() ; i++) {
                res+=list.get(i);
            }
        }
        return res;
    }

    /**
     * 反转list
     * @param list
     */
    public static void reverse(List<Integer>list){
        int left=0;
        int right=list.size()-1;
        while (right>left){
            Integer tmp = list.get(left);
            list.set(left,list.get(right));
            list.set(right,tmp);
            left++;
            right--;
        }
    }

}
