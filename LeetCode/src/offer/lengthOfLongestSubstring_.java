package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/24 15:31
 * @description TODO
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer>map=new HashMap<>();

        char[] chars = s.toCharArray();

        int cur=0;
        int max=0;
        int count=0;
        while (cur<s.length()){
            if(!map.containsKey(chars[cur])){
                map.put(chars[cur],cur);
                count++;
                cur++;
            }else{
                max= Math.max(max,count);
                count=0;
                cur=map.get(chars[cur])+1;
                map.clear();
            }
        }
        return max;
    }

}
