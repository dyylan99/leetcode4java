package offer2;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/29 23:42
 * @description 剑指 Offer II 005. 单词长度的最大乘积
 **/
public class maxProduct_ {
    public int maxProduct(String[] words) {
        int res=0;

        int len=words.length;

        int[]nums=new int[len];
        //核心思路就是将该字符串转化为二进制数,如果每个字母都不相同,那么二进制的每一位数都是不一样的,做与运算就为0
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <words[i].length() ; j++) {
                // 则 abc 可以表示为000111 def 可以表示为 111000 如果不包含重复字符的字符串转换二进制后做与运算肯定为 0
                nums[i]|=(1<<(words[i].charAt(j)-'a'));
            }
        }
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j <len ; j++) {
                if ((nums[i]&nums[j])==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int product = maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"});
        System.out.println(product);
    }
}
