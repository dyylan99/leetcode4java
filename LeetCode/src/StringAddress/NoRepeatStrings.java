package StringAddress;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/30 18:07
 * @description 输出一个字符串的所有最长不重复子串
 **/
public class NoRepeatStrings {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        List<String>list=new ArrayList<>();
        int l=0;
        int r=0;
        int maxLength=0;
        int curLength=0;
        Set<Character>set=new HashSet<>();
        while (l<s.length()&&r<s.length()){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                r++;
                curLength++;
            }else{
                //碰到第一个重复的字符了,先将当前字符串加入到list中
                if(maxLength<=curLength){
                    maxLength=curLength;
                    list.add(s.substring(l,r));
                }
                //找到第一个重复字符的位置
                while (l<s.length()&&s.charAt(l)!=c){
                    set.remove(s.charAt(l));
                    l++;
                    curLength--;
                }
                if(l<s.length()){
                    set.remove(s.charAt(l));
                    l++;
                    curLength--;
                }
            }
        }
        System.out.println(maxLength);
        for (String s1 : list) {
            System.out.println(s1);
        }

    }
}
