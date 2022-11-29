package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/14 13:41
 * @description 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 844:比较含退格的字符串
 **/
public class backspaceCompare__ {
    //双指针法
    /**
     *一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。
     * 因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
     * O(index1+index2+2)
     */
    public boolean backspaceCompare(String s, String t) {
       int index1=s.length()-1;
       int index2=t.length()-1;
       int skipS=0,skipT=0;
       //ad##d
        //bc#e
       while (index1>=0||index2>=0){
           while (index1>=0){
               //遇到了退格符
               if(s.charAt(index1)=='#'){
                   skipS++;
                   index1--;
                   //当退格符数量还是大于零且遇到了字母
               }else if(skipS>0){
                   //退格符数量消耗1
                   skipS--;
                   index1--;
                   //退格符数量为0,且遇到了字母,此时需要跳出循环比较两个字母是否相等
               }else{
                   break;
               }
           }
           while (index2>=0){
               if(t.charAt(index2)=='#'){
                   skipT++;
                   index2--;
               }else if(skipT>0){
                   skipT--;
                   index2--;
               }else{
                   break;
               }
           }
           //如果两个指针都还大于零也就是还未遍历完
           if(index1>=0&&index2>=0){
               if(s.charAt(index1)!=t.charAt(index2)){
                   return false;
               }
           }else{//有一个字符串已经被遍历完
               //但另一个字符串未被遍历完
                if(index1>=0||index2>=0){
                    return false;
                }
           }
           index1--;
           index2--;
       }
       return true;
    }



    //栈思想法
    public boolean backspaceCompare1(String s, String t){
        return buildStr(s).equals(buildStr(t));
    }
    public String buildStr(String str){
        StringBuffer res=new StringBuffer();
        int length=str.length();
        for (int i = 0; i < length; i++) {
            char ch=str.charAt(i);
            if (ch!='#'){
                res.append(ch);
            }else {
                res.deleteCharAt(res.length()-1);
            }
        }
        return res.toString();
    }
}
