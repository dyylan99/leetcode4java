package StringAddress;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/20 16:21
 * @description 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * 459. 重复的子字符串
 **/
public class repeatedSubstringPattern_ {
    public boolean repeatedSubstringPattern(String s) {
        /**
         * 思路:
         *  若目标字符串能被子串重复组成, 那么
         *  s+s 将前后字符去掉一定还能找到s
         */
        String t=s+s;
        String substring = t.substring(1, t.length() - 1);
        return substring.contains(s);
    }


    // KMP算法实现
    public boolean repeatedSubstringPattern1(String s) {
        if(s.length()==0){
            return false;
        }
        int length=s.length();
        int[]next=new int[s.length()];
        getNext(next,s);
        if(next[length-1]>=0&&length%(length-(next[length-1]+1))==0){
            return true;
        }else {
            return false;
        }
    }
    public void getNext(int[]next,String s){
        int j=-1;
        next[0]=j;
        for (int i = 1; i < next.length; i++) {
            while (j>=0&&s.charAt(i)!=s.charAt(j+1)){
                j=next[j];
            }
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i]=j;
        }
    }
}
