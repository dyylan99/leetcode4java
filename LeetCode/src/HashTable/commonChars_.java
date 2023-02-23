package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/22 10:48
 * @description 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 *
 * 1002. 查找共用字符
 **/
public class commonChars_ {
    public List<String> commonChars(String[] words) {
        int[] hash=new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i)-'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int [] hashOtherStr=new int[26];
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                hashOtherStr[words[i].charAt(i1)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j]=Math.min(hash[j],hashOtherStr[j]);
            }
        }
        List<String>res=new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0){
                char c=(char) (i+'a');
                for (int i1 = 0; i1 < hash[i]; i1++) {
                    res.add(String.valueOf(c));
                }
            }
        }
        return res;
    }
}
