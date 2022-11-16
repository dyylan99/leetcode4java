package StringAddress;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/20 12:57
 * @description 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 151. 反转字符串中的单词
 * /**
 * 思路:
 * 1.去除原字符串中的多余空格: 即首尾单词前后不留空格, 其他单词之间只留一个空格
 *
 * 2.反转指定区间字符串
 *
 * 3.反转每个单词
 **/
public class reverseWords__ {
    public String reverseWords(String s){
        StringBuilder stringBuilder = removeSpace(s);
        reverseWords(stringBuilder);
        return stringBuilder.toString();
    }

    public StringBuilder removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        while (s.charAt(start)==' '){
            start++;
        }

        while (s.charAt(end)==' '){
            end--;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while (start<=end){
            char tem=s.charAt(start);
            if(tem!=' '||stringBuilder.charAt(stringBuilder.length()-1)!=' '){
                stringBuilder.append(tem);
            }
            start++;
        }
        return stringBuilder;
    }

    public StringBuilder reverseStr(StringBuilder sb,int start,int end){
        while (start<end){
            char c = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
            start++;
            end--;
        }
        return sb;
    }

    public void reverseWords(StringBuilder sb){
        int start=0;
        int end=1;
        int size=sb.length();
        while (start<size){
            while (end<size&&sb.charAt(end)!=' '){
                end++;
            }
            reverseStr(sb,start,end);
            start=end+1;
            end=start+1;
        }
    }

}
