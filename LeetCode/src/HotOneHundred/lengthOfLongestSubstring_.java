package HotOneHundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/26 11:55
 * @description TODO
 * 3. 无重复字符的最长子串
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int res=1;
        int tem=0;
        Map<Character,Integer>map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //没有重复的
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                tem++;
            }else{
                //遇到重复的,将tem与res开始比较,再从重复的后一位开始
                res=Math.max(tem,res);
                i=map.get(s.charAt(i))+1;
                map.clear();
                tem=1;
                map.put(s.charAt(i),i);
            }
        }
        res=Math.max(tem,res);
        return res;
    }
}
