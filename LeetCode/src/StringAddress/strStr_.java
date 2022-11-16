package StringAddress;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/20 15:03
 * @description 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 1 <= haystack.length, needle.length <= 104
 *
 *
 * 28. 找出字符串中第一个匹配项的下标
 * >>>>>
 **/
public class strStr_ {
    /**
     * 时间复杂度为O(m*n)的滑动窗口算法
     */
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int i=0;
        int j=0;
        while (i<m-n+1){
            while (i<m&&haystack.charAt(i)!=needle.charAt(j)){ //找到第一个相等的字母位置
                i++;
            }
            if(i==m){
                return -1;
            }
            i++;
            j++;
            while (j<n&&i<m&&haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==n){  //j和模式字符串长度相等, 那么说明找到了第一个符合的子串
                return i-j;
            }else{ //不相等的话, 那么回到目标字符串i的后一个位置
                i-=j-1;
                j=0;
            }
        }
        return -1;
    }

    // KMP算法:
    public int strStr1(String haystack, String needle){
        if(needle.length()==0){
            return 0;
        }
        int[]next=new int[needle.length()];
        getNext(next,needle);
        int j=-1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>=0&&haystack.charAt(i)!=needle.charAt(j+1)){
                j=next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }
        return -1;
    }

    //找到next数组
    //j代表前缀末尾
    //i代表后缀末尾
    public static void getNext(int[] next,String s){
        int j=-1;
        next[0]=j;
        for (int i = 1; i < s.length(); i++) {
            //前后缀不相等, 前缀回退, 回退的值为next数组前一位所存储的值
            while (j>=0&&s.charAt(j+1)!=s.charAt(i)){
                    j=next[j];
            }
            //前后缀相等的情况下, j的值加一, 并将当前next[i]的值赋为j, 因此j也代表最大相等前后缀的长度
            if(s.charAt(j+1)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }

    public static void main(String[] args) {
        String s="asdfasdfasdf";
        int[] next=new int[s.length()];
        getNext(next,s);
        System.out.println(Arrays.toString(next));
    }

}
