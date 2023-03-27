package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/26 12:28
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 **/
public class firstUniqChar_ {
    public char firstUniqChar(String s) {
        int[]chars=new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(chars[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
