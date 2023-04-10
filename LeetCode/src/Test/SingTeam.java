package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/7 16:21
 * @description TODO
 **/
public class SingTeam {
    //从左到右最长递增子序列
    //从右往左最长递增子序列
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int[]nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        //从左到右
        int[]dp1=new int[n];
        //从右到左
        int[]dp2=new int[n];
        for (int i = 1; i < n; i++) {
            dp1[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp1[i]=Math.max(dp1[i],dp1[j]+1);
                }
            }
        }

        for (int i = n-1; i>=0; i--) {
            dp2[i]=1;
            for (int j = n-1; j>i ; j--) {
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp2[j]+1);
                }
            }
        }

        int maxLength=0;
        for (int i = 0; i < n; i++) {
            maxLength=Math.max(maxLength,dp1[i]+dp2[i]-1);
        }
        System.out.println(n-maxLength);

    }


}
