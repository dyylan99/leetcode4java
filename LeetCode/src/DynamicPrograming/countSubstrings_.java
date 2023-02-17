package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/17 11:31
 * @description 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 * 647. 回文子串
 **/
public class countSubstrings_ {
    //动态规划法
    public int countSubstrings1(String s){
        //dp数组的定义: dp[i][j]为s在区间[i,j]上的子串是否为回文串
       boolean[][] dp=new boolean[s.length()][s.length()];
        int res=0;
        for (int i=s.length();i>=0;i--){
            for (int j = i; j <s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        res++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){//i,j同时回收一格
                        res++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return res;
    }



    //双指针法
    public int countSubstrings(String s) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            res+=extend(s,i,i,s.length());//单中心点
            res+=extend(s,i,i+1,s.length());//双中心点
        }
        return res;
    }

    public int extend(String s,int i,int j,int size){//i是第一个中心点, j是第二个中心点
        int res=0;
        while (i>=0&&j<size&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            res++;
        }
        return res;
    }

}
