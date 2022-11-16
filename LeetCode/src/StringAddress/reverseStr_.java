package StringAddress;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/19 19:23
 * @description 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 541. 反转字符串 II
 **/
public class reverseStr_ {
    public String reverseStr(String s, int k) {
        StringBuffer res=new StringBuffer();
        int length=s.length();
        int start=0;
        while (start<length){
            StringBuffer tem=new StringBuffer();
            int firstK=(start+k>length)?length:start+k;
            int secondK=(start+(2*k)>length?length:start+(2*k));
            tem.append(s, start, firstK);
            res.append(tem.reverse());
            if(firstK<secondK){
                res.append(s, firstK, secondK);
            }
            start+=(2*k);
        }
        return res.toString();
    }
    public String reverseStr1(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
