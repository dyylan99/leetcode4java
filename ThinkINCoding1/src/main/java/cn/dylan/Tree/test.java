package cn.dylan.Tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/21 14:23
 * @description TODO
 **/
public class test {

    public int transform(String s){
        Map<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        int index=0;
        while (index<s.length()){
            if (s.charAt(index)=='I'){
                if (index+1<s.length()){
                    if (s.charAt(index+1)=='V'){
                        res+=4;
                        index++;
                    } else if (s.charAt(index+1)=='X') {
                        res+=9;
                        index++;
                    }else{
                        res+=1;
                    }
                }
            }else if (s.charAt(index)=='X'){
                if (index+1<s.length()){
                    if (s.charAt(index+1)=='L'){
                        res+=40;
                        index++;
                    } else if (s.charAt(index+1)=='C') {
                        res+=90;
                        index++;
                    }else{
                        res+=10;
                    }
                }
            }else if (s.charAt(index)=='C'){
                if (index+1<s.length()){
                    if (s.charAt(index+1)=='D'){
                        res+=400;
                        index++;
                    }else if (s.charAt(index+1)=='M'){
                        res+=900;
                        index++;
                    }else {
                        res+=100;
                    }
                }
            }else{
                res+=map.get(s.charAt(index));
            }
            index++;
        }
        return res;
    }
    @Test
    public void test(){
       test1();
    }
    public void test1() throws Error{
        char a='潘';
        System.out.println(a);
    }

    public void test2(){
        try {
            test1();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }


}
