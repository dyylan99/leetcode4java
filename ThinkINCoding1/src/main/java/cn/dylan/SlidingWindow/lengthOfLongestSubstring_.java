package cn.dylan.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 16:49
 * @description TODO
 **/
public class lengthOfLongestSubstring_ {
    public int lengthOfLongestSubstring(String s){
        if (s==null || s.isEmpty()){
            return 0;
        }
        int res=1;
        //滑动窗口左边界
        int left=0;
        int i;
        Map<Character,Integer>map=new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //当前元素不在窗口中, 直接加入
            if (!map.containsKey(c)){
                map.put(s.charAt(i),i);
                res=Math.max(res,i-left+1);
                //否则
            }else{
                int pre=map.get(c);
                //如果map中重复的元素下标小于滑动窗口左边界,说明该元素已经被排除在外
                if (pre<left){
                    //更新
                    map.put(c,i);
                    res=Math.max(res,i-left+1);
                }else{
                    //窗口中遇到了重复元素, 取出当前窗口的长度
                    res=Math.max(res,i-left);
                    //更新窗口, 排除第一个重复的元素
                    left=map.get(c)+1;
                    //将当前元素加入到窗口中
                    map.put(c,i);
                }

            }
        }
        return res;
    }
}
