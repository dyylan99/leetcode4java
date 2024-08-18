package DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/30 23:20
 * @description 3. 无重复字符的最长子串
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int res=0;
        Map<Character,Integer> map=new HashMap<>();
        while (right<s.length()){
            char c=s.charAt(right);
            if (map.containsKey(c)){
                left=Math.max(left,map.get(c)+1);
            }
            res=Math.max(res,right-left+1);
            map.put(c,right);
            right++;
        }
        return res;
    }
}
