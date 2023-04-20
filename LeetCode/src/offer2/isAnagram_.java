package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 15:03
 * @description TODO
 **/
public class isAnagram_ {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }

        int[]chars=new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)-'a']--;
        }
        for (int aChar : chars) {
            if (aChar!=0){
                return false;
            }
        }
        return true;
    }
}
