package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/22 15:04
 * @description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 438. 找到字符串中所有字母异位词
 **/
public class findAnagrams_ {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        int countS=s.length();
        int countP=p.length();
        if(countP>countS){
            return res;
        }
        int []sInt=new int[26];
        int []pInt=new int[26];
        for (int i = 0; i < countP; i++) {
            sInt[s.charAt(i)-'a']++;
            pInt[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(sInt,pInt)){
            res.add(0);
        }
        //本质上还是滑动窗口
        for (int i = countP; i < countS; i++) {
            sInt[s.charAt(i-countP)-'a']--;  //将窗口外的元素映射值减一
            sInt[s.charAt(i)-'a']++;
            if(Arrays.equals(sInt,pInt)){
                res.add(i-countP+1);
            }
        }
        return res;

    }
}
