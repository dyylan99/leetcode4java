package offer2;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/13 18:57
 * @description 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 **/
public class checkInclusion_ {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }

        Map<Character,Integer>map=new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int n=s1.length();
        int left=0,right=0;
        while (right<s2.length()) {
            char c=s2.charAt(right);
            if (map.containsKey(c)){
                if(map.get(c)>0){
                    n--;
                }
                map.put(c,map.get(c)-1);
            }
            left=right-s1.length();
            if (left>=0){
                char ch=s2.charAt(left);
                if (map.containsKey(ch)){
                    if (map.get(ch)>=0){
                        n++;
                    }
                    map.put(ch,map.get(s2.charAt(left))+1);
                }
            }
            if (n==0){
                return true;
            }
            right++;
        }
        return false;
    }
}
