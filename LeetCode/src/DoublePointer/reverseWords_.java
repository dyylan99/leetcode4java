package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/14 15:22
 * @description 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *151. 反转字符串中的单词
 **/
public class reverseWords_ {
    /**
     * 直接对创建新字符数组,对源字符串进行遍历:
     */
    public String reverseWords1(String s){
        char[] initialChars = s.toCharArray();
        //之所以是s.length()+1是因为要在每个单词之后都加一个空格
        char[] newChars=new char[s.length()+1];
        int newIndex=0;
        int i=s.length()-1;
        while(i>=0){
            //去除末尾多余空格:
            while (i>=0&&initialChars[i]==' '){
                i--;
            }
            int right=i;
            while (i>=0&&initialChars[i]!=' '){
                i--;
            }
            //此时i到了单词前一位空格
            for (int j = i+1; j <= right; j++) {
                newChars[newIndex++]=initialChars[j];
                if(j==right){
                    newChars[newIndex++]=' ';//单词末尾的空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newIndex == 0){
            return "";
        }else{
            //将最后的空格去掉
            return new String(newChars,0,newIndex-1);
        }
    }
    
    
    
    
    /**
     * 步骤:
     *1.去除多余字符串
     * 2.反转字符串
     * 3.反转每个单词
     */
    public String reverseWords(String s) {
        StringBuilder res = removeSpace(s);
        reverseStr(res,0,res.length()-1);
        reverseEachWord(res);
        return res.toString();
    }

    //1.去除多余字符串
    private StringBuilder removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        //去除首尾空格符
        while (s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }

        StringBuilder sb=new StringBuilder();
        while (start<=end){
            char c=s.charAt(start);
            //若取出的字符串字符不为空格或者sb的最后一位不是空格
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    //2.反转指定区间字符串
    public void reverseStr(StringBuilder sb,int start,int end){
        while (start<end){
            char c=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
            start++;
            end--;
        }
    }
    //3.反转每个单词
    private void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=1;
        int n=sb.length();
        while (start<n){
            while (end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverseStr(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }

}
