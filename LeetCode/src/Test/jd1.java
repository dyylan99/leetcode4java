package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/16 10:20
 * @description TODO
 **/
public class jd1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //朋友的个数
        int m=sc.nextInt(); //楼梯的个数
        int H=sc.nextInt(); //小红的身高

        int[]h=new int[n]; //朋友的身高
        int[] stage=new int[n]; //每个朋友站在第几阶楼梯上
        for (int i = 0; i < h.length; i++) {
            h[i]=sc.nextInt();
        }
        for (int i = 0; i < stage.length; i++) {
            stage[i]=sc.nextInt();
        }
        int[] height=new int[m]; //每阶楼梯的高度
        int maxHeight=0;
        for (int i = 0; i < m; i++) {
            height[i]=sc.nextInt();
            maxHeight=Math.max(maxHeight,height[i]);
        }
        //计算每个人站在楼梯上的高度, 与此同时,计算小红站在最高楼梯上的高度
        int[]sum=new int[n];
        for (int i = 0; i < n; i++) {
            sum[i]=h[i]+height[stage[i]-1];
        }
        int target=maxHeight+H;
        int count=0;
        for (int i : sum) {
            if (i<target){
                count++;
            }
        }
        System.out.println(count);


    }

}
