package HashTable;

import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/22 14:01
 * @description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 strs[i] 仅包含小写字母
 *
 * 49. 字母异位词分组
 **/
public class groupAnagrams_ {

    //大量使用类库,性能极差
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        List<List<String>>res=new ArrayList<>(length);
        Map<int[],List<String>>map=new HashMap<>();
        for (String str : strs) {
            int[]rec=new int[26];
            boolean isContains=false;
            for (int i = 0; i < str.length(); i++) {
                rec[str.charAt(i)-'a']++;
            }
            for (int[] ints : map.keySet()) {
                if (Arrays.equals(ints,rec)){
                    List<String> strings = map.get(ints);
                    strings.add(str);
                    map.replace(rec,strings);
                    isContains=true;
                }
            }
            if (!isContains){
                List<String>strings=new ArrayList<>();
                strings.add(str);
                map.put(rec, strings);
            }

        }
        //for (Map.Entry<int[], List<String>> listEntry : map.entrySet()) {
        //    res.add(listEntry.getValue());
        //}
        return new ArrayList<>(map.values());
    }

    /**
     *由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     *
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 26 的数组记录每个字母出现的次数。需要注意的是，在使用数组作为哈希表的键时
     */
    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>>map=new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if(counts[i]!=0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key=sb.toString();
            List<String>list=map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
      return new ArrayList<>(map.values());
    }




    @Test
    public void test(){
        List<String> strings = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        String[]strs=new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            strs[i]=strings.get(i);
        }
        System.out.println(groupAnagrams(strs));
    }
}
