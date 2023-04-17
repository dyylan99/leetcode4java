package offer2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/17 17:14
 * @description TODO
 **/
public class isAlienSorted_ {
    Map<Character,Integer>map=new HashMap<>();
    public boolean isAlienSorted1(String[] words, String order) {
        //初始化map
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
            int len=Math.min(a.length(),b.length());
            for (int i = 0; i < len; i++) {
                char c1=a.charAt(i);
                char c2=b.charAt(i);
                if (c1!=c2){
                    return map.get(c1)-map.get(c2);
                }
            }
            //走到这一步说明长串和短串前面的都一样
            //谁长谁在前面
            if (a.length()>len){
                return 1;
            }else if(b.length()>len){
                return -1;
            }
           return 0;
        });
        for (String word : words) {
            pq.add(word);
        }
        for (String word : words) {
            String remove = pq.remove();
            if (!word.equals(remove)){
                return false;
            }
        }
        return true;
    }

    //改良版
    public boolean isAlienSorted(String[] words, String order){
        if (words.length<2){
            return true;
        }
        int[]index=new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i)-'a']=i;
        }
        for (int i = 1; i <words.length ; i++) {
            int len=Math.min(words[i-1].length(),words[i].length());

            for (int j = 0; j < len; j++) {
                int pre=index[words[i-1].charAt(j)-'a'];
                int cur=index[words[i].charAt(j)-'a'];
                if(pre>cur){
                    return false;
                }else if (pre<cur){
                    break;
                }
                if (j==len-1&&words[i-1].length()>len)return false;
            }
        }
        return true;

    }
}
