package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 20:34
 * @description 最多删除一个字符串回文
 **/
public class validPalindrome_ {
    public boolean validPalindrome(String s) {
        if (s.length()==1){
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return isValid(s,left+1,right)|| isValid(s,left,right-1);
            }
        }
        return true;
    }
    public boolean isValid(String s,int left, int right){
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
