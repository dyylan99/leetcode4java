package StringAddress;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/19 19:21
 * @description 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 344. 反转字符串
 **/
public class reverseString_ {
    public void reverseString(char[] s) {
        int index1=0;
        int index2=s.length-1;
        char tem='t';
        while (index2>index1){
            tem=s[index1];
            s[index1]=s[index2];
            s[index2]=tem;
            index1++;
            index2--;
        }
    }

}
