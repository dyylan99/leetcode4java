package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/11 16:35
 * @description 兄弟字符串
 **/
public class BrotherWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str = sc.nextLine();
        String[] strings = str.split(" ");

        //第一个是样本字符串的数目
        //倒数第一个是k
        int n=Integer.parseInt(strings[0]);
        //样本字符串list
        List<String> list = new ArrayList<>();
        //目标字符串
        String target=strings[n+1];

        //k
        int k=Integer.parseInt(strings[n+2]);
        for (int i = 1; i <=n ; i++) {
            if(isBrotherWord(strings[i],target)){
                list.add(strings[i]);
            }
        }
        int size = list.size();
        System.out.println(size);
        if(size>=k){
            Collections.sort(list);
            System.out.println(list.get(k-1));
        }

    }
    //判断是否是兄弟字符串
    public static boolean isBrotherWord(String sour,String str){
        if(sour.equals(str)){
            return false;
        }
        char[] chars1 = str.toCharArray();
        char[] chars2=sour.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
}
