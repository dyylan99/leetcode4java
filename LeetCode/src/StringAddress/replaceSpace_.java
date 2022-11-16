package StringAddress;/**
 *@author Dylan
 *@date   2022/11/20 12:44
 *@version 1.0
 *@description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 剑指 Offer 05. 替换空格
 **/public class replaceSpace_ {
     //借助额外空间解决
    public String replaceSpace(String s) {
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
