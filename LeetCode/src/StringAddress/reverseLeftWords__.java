package StringAddress;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/20 13:27
 * @description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *剑指 Offer 58 - II. 左旋转字符串
 **/
public class reverseLeftWords__ {
    /**
     * 思路:
     * 先反转整个字符串
     * 再反转后n个
     * 再反转剩下的
     */
    public String reverseLeftWords(String s, int n){
        char[] res=s.toCharArray();
        int size=s.length();
        reverseChars(res,0,size-1);
        reverseChars(res,0,size-n-1);
        reverseChars(res,size-n,size-1);
        return new String(res);
    }

    public void reverseChars(char[]chars,int start,int end){
        while (start<end){
            chars[start]^=chars[end];
            chars[end]^=chars[start];
            chars[start]^=chars[end];
            end--;
            start++;
        }
    }
}
