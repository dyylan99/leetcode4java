package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 20:27
 * @description TODO
 **/
public class kedaxunfei3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int sumA=0;
        int sumB=0;
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            sumA+=a[i];
            b[i]=sc.nextInt();
            sumB+=b[i];
        }
        if (sumA%2!=0 || sumB%2!=0){
            System.out.println(-1);
            return;
        }
        int[][]dp=new int[n+1][sumA/2+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=sumA/2 ; j++) {
                if (j>=a[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-a[i-1]]+b[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if (dp[n][sumA/2]!=sumB/2){
            System.out.println(-1);
        }else{
            getGroup(dp,sumA/2);
        }

    }
    private static void getGroup(int[][]dp,int sumA){
        int n=dp[0].length-1;
        List<Integer>g1=new ArrayList<>();
        List<Integer>g2=new ArrayList<>();
        for (int i = n-1; i>=0; i--) {
            if (dp[i][sumA]==dp[n][sumA]){
                g1.add(i);
            }else if (dp[i][sumA]!=0){
                g2.add(i);
            }
        }
        if (g1.isEmpty() || g2.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(g1.size()+" "+g2.size());
            for (int i = 0; i < g1.size(); i++) {
                if (i!=g1.size()-1){
                    System.out.print(g1.get(i)+" ");
                }else{
                    System.out.println(g1.get(i));
                }
            }
            for (int i = 0; i < g2.size(); i++) {
                if (i!=g2.size()-1){
                    System.out.print(g2.get(i)+" ");
                }else{
                    System.out.println(g2.get(i));
                }
            }
        }
    }
}
