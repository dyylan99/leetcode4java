package Test;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 19:41
 * @description TODO
 **/
public class X_RED {
    //超时
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if(x==1){
            System.out.println("r");
            return;
        }
        System.out.println(getX(x));

    }
    //利用r,e,d构造字符串使得其回文子串等于x
    public static String getX(int x){
        int cur;
        String s;
        while (true){
            sb.append("r");
            s=sb.toString();
            cur=Math.max(getCount(s,s.length()/2),getCount1(s,s.length()/2,s.length()/2+1));
            if(cur==x){
                return sb.toString();
            }
            sb.append("e");
            s=sb.toString();
            cur=Math.max(getCount(s,s.length()/2),getCount1(s,s.length()/2,s.length()/2+1));
            if(cur==x){
                return sb.toString();
            }
            sb.append("d");
            s=sb.toString();
            cur=Math.max(getCount(s,s.length()/2),getCount1(s,s.length()/2,s.length()/2+1));
            if(cur==x){
                return sb.toString();
            }
        }

    }

    //给定一个字符串求回文子串的数量-->单个中心
    public static int getCount(String s,int left){
        int count=0;
        int tmp=left;
        int index1=left;
        int index2=left;
        while (index1>=0&&index2<s.length()){
            while (index1>=0&&index2<s.length()&&s.charAt(index1)==s.charAt(index2)){
                count++;
                index1--;
                index2++;
            }
            tmp--;
            index1=tmp;
            index2=tmp;
        }
        index1=left+1;
        index2=left+1;
        tmp=left+1;
        while (index1>=0&&index2<s.length()){
            while (index1>=0&&index2<s.length()&&s.charAt(index1)==s.charAt(index2)){
                count++;
                index1--;
                index2++;
            }

            tmp++;
            index1=tmp;
            index2=tmp;
        }
        return count;
    }

    //双中心
    public static int getCount1(String s,int left,int right){
        int count=0;
        int tmp1=left;
        int tmp2=right;
        int index1=tmp1;
        int index2=tmp2;
        while (index1>=0&&index2<s.length()){
            while (index1>=0&&index2<s.length()&&s.charAt(index1)==s.charAt(index2)){
                count++;
                index1--;
                index2++;
            }
            tmp1--;
            tmp2--;
            index1=tmp1;
            index2=tmp2;
        }
        tmp1=right;
        tmp2=right+1;
        index1=tmp1;
        index2=tmp2;
        while (index1>=0&&index2<s.length()){
            while (index1>=0&&index2<s.length()&&s.charAt(index1)==s.charAt(index2)){
                count++;
                index1--;
                index2++;
            }
            tmp1++;
            tmp2++;
            index1=tmp1;
            index2=tmp2;
        }
        return count+s.length();
    }
    @Test
    public void test(){
        System.out.println(getCount("rededf",2));
        System.out.println(getCount1("abba",1,2));
    }


}
