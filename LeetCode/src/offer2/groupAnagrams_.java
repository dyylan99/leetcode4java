package offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 13:20
 * @description TODO
 **/
public class groupAnagrams_ {
    public List<List<String>> groupAnagrams(String[] strs) {
        //key是字符加上出现的次数组成的字符串
        Map<String,List<String>>map=new HashMap<>();

        for (String str : strs) {
            int[]count=new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)-'a']++;
            }
            //key
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i]>0){
                    sb.append((char) ('a'+i));
                    sb.append(count[i]);
                }
            }
            String key=sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());

    }
}
