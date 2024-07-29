package StringAddress;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/5/18 10:28
 * @description 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 **/
public class oneEditAway_ {

    public boolean oneEditAway(String first, String second) {
        int length1 = first.length();
        int length2 = second.length();
        if (Math.abs(length1 - length2) > 1){
            return false;
        }
        int i=0,j=0;
        int count=0;
        while (i<length1 && j<length2){
            if (first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            }else {
                count++;
                if (length1==length2){
                    i++;
                    j++;
                }else if(length1>length2){
                    i++;
                }else {
                    j++;
                }
            }
        }
        return count<=1;
    }
}
