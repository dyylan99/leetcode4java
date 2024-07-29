package cn.dylan.test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/16 11:16
 * @description TODO
 **/
public class HuaWei {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        int left=0;
        int right=1;
        if (s.equals("")){
            return;
        }
        char[] charArray = s.toCharArray();
        ArrayDeque<Character>queue=new ArrayDeque<>();
        // ( 入栈, 遇到 )从栈中弹出左括号, 当栈为空说明一个待处理的原语字符串就形成了
        StringBuilder sb=new StringBuilder();
        queue.add(charArray[0]);
        for (int n =1; n < charArray.length; n++) {
            if (charArray[n]==')'){
                //弹出左括号
                queue.pollLast();
            }else{
                if (queue.isEmpty()){
                    right=n;
                    sb.append(s,left+1,right-1);
                    left=n;
                }
                queue.add(charArray[n]);
            }
        }
        sb.append(s,left+1,s.length()-1);
        System.out.println(sb.toString());
    }
}
