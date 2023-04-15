package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 21:00
 * @description 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 *
 **/
public class isPalindrome_ {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (!(s.charAt(left)-'a'>=0&&s.charAt(left)-'z'<=0)&&!Character.isDigit(s.charAt(left))){
                left++;
                continue;
            }
            if (!(s.charAt(right)-'a'>=0&&s.charAt(right)-'z'<=0)&&!Character.isDigit(s.charAt(right))){
                right--;
                continue;
            }
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
