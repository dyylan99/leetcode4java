package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jd3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x==y){
            System.out.println(0);
            return;
        }
        List<Integer> ops = transform(x, y);
        if (ops.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(ops.size());
            for (Integer op : ops) {
                System.out.print("+"+" ");
                System.out.println(op);
            }
        }

    }

    public static List<Integer> transform(int x, int y) {
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);
        int len = Math.max(binaryX.length(), binaryY.length());
        List<Integer> values = new ArrayList<>(); // 保存每次操作后的 x 的值  
        int i = 0;
        while (i < len) {
            char chX = i < binaryX.length() ? binaryX.charAt(i) : '0';
            char chY = i < binaryY.length() ? binaryY.charAt(i) : '0';
            if (chX == '0' && chY == '1') {
                // 找到 x 中下一个为 1 的位，然后将该位和当前位之间的所有位都取反  
                int nextOneIndex = binaryX.indexOf('1', i + 1);
                if (nextOneIndex != -1) {
                    StringBuilder sb = new StringBuilder(binaryX);
                    for (int j = i + 1; j < nextOneIndex; j++) {
                        sb.setCharAt(j, sb.charAt(j) == '0' ? '1' : '0');
                    }
                    binaryX = sb.toString();
                    x = Integer.parseInt(binaryX, 2); // 将二进制字符串转换回整数  
                    values.add(x); // 保存操作后的 x 的值  
                } else {
                    // 如果在 x 中找不到下一个为 1 的位，则无法转换，退出循环  
                    break;
                }
            } else if (chX == '1' && chY == '0') {
                // 找到 x 中下一个为 1 的位，然后将该位和当前位之间的所有位都取反  
                int nextOneIndex = binaryX.indexOf('1', i + 1);
                if (nextOneIndex != -1) {
                    StringBuilder sb = new StringBuilder(binaryX);
                    for (int j = i + 1; j < nextOneIndex; j++) {
                        sb.setCharAt(j, sb.charAt(j) == '0' ? '1' : '0');
                    }
                    binaryX = sb.toString();
                    x = Integer.parseInt(binaryX, 2); // 将二进制字符串转换回整数  
                    values.add(x); // 保存操作后的 x 的值  
                } else {
                    // 如果在 x 中找不到下一个为 1 的位，则无法转换，退出循环  
                    break;
                }
            }
            i++;
        }
       return values;
    }
}