package offer2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/13 17:55
 * @description 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 *
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 *
 *
 * 滑动窗口
 **/
public class minWindow_ {

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    //"ADOBECODEBANC", t = "ABC"
    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        //需要匹配的数量
        int n=t.length();
        Map<Character,Integer>map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        //最短长度的左右端点
        int start=0,end=-1;
        //最短的长度
        int minLen=Integer.MAX_VALUE;
        int left=0,right=0;
        while (right<s.length()){
            //窗口向右移动一位
            char c=s.charAt(right);
            //若c位于t中
            if (map.containsKey(c)){
                if(map.get(c)>0){
                    //还有需求
                    n--;
                }
                map.put(c,map.get(c)-1);
            }
            //窗口持续右移
            while (n==0){ //若窗口已经满足要求,覆盖了t
                if (right-left+1<minLen){
                    //出现了更短的子串
                    minLen=right-left+1;
                    start=left;
                    end=right;
                }
                char ch=s.charAt(left);
                if (map.containsKey(ch)){
                    if (map.get(ch)>=0){
                        //对ch还有需求,划出窗口对n有影响
                        n++;
                    }
                    map.put(ch,map.get(ch)+1);
                }
                left++;
            }
            right++;
        }
        return s.substring(start,end+1);
    }
}
