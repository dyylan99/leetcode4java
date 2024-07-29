package cn.dylan.String;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/15 18:34
 * @description 151. 反转字符串中的单词
 **/
public class reverseWords_ {
    public String reverseWords(String s) {
        s=s.trim();
        if (s.length()==1){
            return s;
        }
        int fast=s.length()-1;
        int slow=s.length()-2;
        StringBuilder sb=new StringBuilder();
        while (slow<=fast && slow>=0){
            //slow走到了空格
            if (s.charAt(slow)==' ' && s.charAt(slow+1)!=' '){
                sb.append(s,slow+1,fast+1);
                sb.append(" ");
            }
            //走到了空格前
            if (s.charAt(slow)!=' ' && s.charAt(slow+1)==' '){
                fast=slow;
            }
            if (slow==0){
                sb.append(s,0,fast+1);
            }
            slow--;
        }
        return sb.toString();
    }
}
