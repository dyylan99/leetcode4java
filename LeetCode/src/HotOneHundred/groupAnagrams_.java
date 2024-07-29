package HotOneHundred;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/27 10:09
 * @description TODO
 **/
public class groupAnagrams_ {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>>res=new ArrayList<>();

       Map<String,List<String>>map=new HashMap<>();
       for (String str : strs) {
           String concat = getConcat(str);
           if(map.containsKey(concat)){
               map.get(concat).add(str);
           }else {
               List<String>list=new ArrayList<>();
               list.add(str);
               map.put(concat,list);
           }
       }
        map.entrySet().forEach(entry->{
            res.add(entry.getValue());
        });
        return res;

    }

    private String getConcat(String s){
        char[]chars=s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


}
