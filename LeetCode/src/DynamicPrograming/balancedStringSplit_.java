package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/24 12:27
 * @description 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
 *
 * 每个子字符串都是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *1221. 分割平衡字符串
 **/
public class balancedStringSplit_ {
    public int balancedStringSplit(String s) {
        byte[] bytes = s.getBytes();
        int flag=0;
        int res=0;
        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i]=='L'){
                flag++;
            }
            if(bytes[i]=='R'){
                flag--;
            }
            if(flag==0){
                res++;
            }
        }
        return res;
    }
}
