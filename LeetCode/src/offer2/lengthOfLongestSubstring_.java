package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/16 15:51
 * @description TODO
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int res=1;
        int left=0;
        Map<Character,Integer>map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,i);
                res=Math.max(res,i-left+1);
            }else{
                int pre = map.get(c);
                //如果pre小于left说明已经被排除在外:
                if (pre<left){
                    map.put(c,i);
                    res=Math.max(res,i-left+1);
                }else{
                    //pre大于left: 需要更新map和left:
                    int len=i-left;
                    res=Math.max(res,len);
                    //更新left
                    left=map.get(c)+1;
                    //更新map
                    map.put(c,i);
                }

            }
        }
        return res;
    }
}
