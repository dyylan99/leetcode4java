package DynamicPrograming;

import java.sql.Statement;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/24 12:33
 * @description 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
 * 5. 最长回文子串
 **/
public class longestPalindrome_ {

    public String longestPalindrome(String s) {
        String s1="";
        String s2="";
        String res="";
        for (int i = 0; i < s.length(); i++) {
            //一个元素作为中心点
            s1=extend(s,i,i);
            res=s1.length()>res.length()?s1:res;
            //两个元素作为中心点
            s2=extend(s,i,i+1);
            res=s2.length()>res.length()?s2:res;
        }
        return res;
    }

    public String extend(String s,int start,int end){
        String tem="";
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            tem=s.substring(start,end+1);
            start--;
            end++;
        }
        return tem;
    }
}
