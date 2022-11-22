package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/22 13:41
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 242. 有效的字母异位词
 *
 *
 **/
public class isAnagram_ {
    //时间复杂度为O(m+n),空间复杂度为O(1)
    //该种解法只有当给定的字符串只包含小写字母时才可以
    //若未写明可以将record长度提升为128
    public boolean isAnagram(String s, String t) {
        //利用hash表将小写字母映射到数组中
        int length=s.length();
        int[]record=new int[26];
        for (int i = 0; i < length; i++) {
            record[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i)-'a']--;
        }
        for (int i : record) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
