package cn.dylan.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 16:49
 * @description TODO
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring(String s){
       if(s.isEmpty()){
           return 0;
       }
       Map<Character,Integer>map=new HashMap<>();
       int left=0,max=1;
        for (int n = 0; n < s.length(); n++) {
            if (map.containsKey(s.charAt(n))){
                left=Math.max(left,map.get(s.charAt(n))+1);
            }
            map.put(s.charAt(n),n);
            max=Math.max(max,n-left+1);
        }
        return max;
    }
}
