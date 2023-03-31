package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 15:26
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 **/
public class reverseWords_ {
    public String reverseWords(String s) {
        s=s.trim();
        //"a good   example"-------> "a" ""
        String[] strings = s.split(" ");
        //这个字符串数组每个单词前后也可能包含空格
        StringBuilder sb=new StringBuilder();
        for (int i = strings.length-1; i>=0; i--) {
            if(strings[i].length()>0){
                sb.append(strings[i]+" ");
            }
        }
        if(sb.length()==0){
            return s;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    @Test
    public void test(){
        System.out.println(reverseWords("a good   example"));
    }
}
