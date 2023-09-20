package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 19:22
 * @description TODO
 **/
public class xinye2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M = sc.nextInt();
        int n = sc.nextInt();
        int[]weight=new int[n];
        for (int i = 0; i < n; i++) {
            weight[i]=sc.nextInt();
        }
        
        int[][]dp=new int[n+1][M+1];
        for (int i = 0; i <n+1; i++) {
            dp[i][0]=1;
        }
        //for (int i = 1; i <=n; i++) {
        //    for (int j = 0; j <=M; j++) {
        //        if (j==0 || j==weight[i-1]){
        //            dp[i][j]=1;
        //        }else{
        //            dp[i][j]=dp[i-1][j];
        //        }
        //    }
        //}
        for (int i = 1; i <=n ; i++) {
            for (int j = M; j>=weight[i-1]; j--) {
                dp[i][j]+=dp[i-1][j-weight[i-1]];
            }
        }
        System.out.println(dp[n][M]);

    }
}
