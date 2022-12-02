package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/2 14:01
 * @description 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 * 131. 分割回文串
 **/
public class partition_ {
    List<List<String>>res=new ArrayList<>();

    LinkedList<String>path=new LinkedList<>();

    public void backTracking(String s,int startIndex){
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex;i<s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                String s1 = s.substring(startIndex, i + 1);
                path.add(s1);
            }else{
                continue;
            }
            backTracking(s,i+1);
            path.removeLast();
        }
    }

    //判断是否是回文字符串
    boolean isPalindrome(String s,int start,int end){
        for (int i = start,j=end; i < j; i++,j--) {
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }




}
