package Test;

import org.junit.Test;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 14:36
 * @description 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 **/
public class charCounts {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String all="";
        String one="";
        char[] ac;
        int num=0;
        while(s.hasNext())
        {

            all=s.nextLine();
            one=s.nextLine();
            //存放原来所有的
            ac=all.toCharArray();
            for(int i=0;i<ac.length;i++)
            {
                if(one.equalsIgnoreCase(String.valueOf(ac[i])))
                    num++;
            }
            System.out.println(num);
        }
    }
    @Test
    public void test(){
        System.out.println("anYdh2LL .".toLowerCase());
    }
}
