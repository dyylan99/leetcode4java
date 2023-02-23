package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/22 10:39
 * @description 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 * 205. 同构字符串
 **/
public class isIsomorphic_ {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>map1=new HashMap<>();
        Map<Character,Character>map2=new HashMap<>();
        for (int i = 0,j=0; i <s.length() ; i++,j++) {
            if(!map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i),t.charAt(j));
            }
            if(!map2.containsKey(t.charAt(j))){
                map2.put(t.charAt(j),s.charAt(i));
            }
            if(map1.get(s.charAt(i))!=t.charAt(j)||map2.get(t.charAt(j))!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
