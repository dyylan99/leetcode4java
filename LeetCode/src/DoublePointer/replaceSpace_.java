package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/14 15:11
 * @description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 **/
public class replaceSpace_ {
    public String replaceSpace1(String s) {
        return s.replace(" ","%20");
    }
    public String replaceSpace(String s){
       char[] res=new char[s.length()*3];
       int j=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                res[j++]=s.charAt(i);
            }else{
                res[j++]='%';
                res[j++]='2';
                res[j++]='0';
            }
        }
        return new String(res,0,j);
    }
}
