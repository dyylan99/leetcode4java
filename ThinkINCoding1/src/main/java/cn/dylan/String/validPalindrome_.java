package cn.dylan.String;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 17:09
 * @description 680. 验证回文串 II
 **/
public class validPalindrome_ {

    public boolean validPalindrome(String s) {
        if (s.length()<=2){
            return true;
        }
        int l=0,r=s.length()-1;
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
               return isValid(s,l+1,r) || isValid(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean isValid(String s, int i, int j){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test1(){
        boolean abca = validPalindrome("abca");
        System.out.println(abca);
    }

}
