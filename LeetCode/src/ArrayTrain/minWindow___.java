package ArrayTrain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/28 13:53
 * @description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 *
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  76. 最小覆盖子串
 **/
public class minWindow___ {
    public String minWindow(String s, String t) {
        //记录滑动窗口的字符及其对应数量
        Map<Character,Integer>window=new HashMap<>();
        //记录目标字符串对应字符和对应数量
        Map<Character,Integer>needs=new HashMap<>();
        //存储
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int count=0;  //记录当前窗口符合needs字符的数量 ,当count==needs.size时即可shrik窗口
        int start = 0;//start表示符合最优解的substring的起始位序
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(needs.get(c).equals(window.get(c))){
                    count++;
                }
            }
            //shrink左边界,找到最优位置
            while (count==needs.size()){
                //记录当前解
                if(right-left<len){
                    len=right-left;
                    start=left;
                }
                //优化当前解
                char d=s.charAt(left);
                left++;
                //如果目标字符串包含刚刚被跳过的字符,那么count就要减一
                if(needs.containsKey(d)){
                    if(needs.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
