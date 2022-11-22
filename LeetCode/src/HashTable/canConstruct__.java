package HashTable;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/22 13:57
 * @description 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * 383. 赎金信
 **/
public class canConstruct__ {
    //使用hash表映射
    public boolean canConstruct(String ransomNote, String magazine) {
        int[]rec=new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            rec[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            rec[ransomNote.charAt(i)-'a']--;
        }
        for (int i : rec) {
            if(i<0){
                return false;
            }
        }
        return true;
    }
}
