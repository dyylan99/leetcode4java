package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/23 14:46
 * @description TODO
 **/
public class wy3 {
    static int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[]nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        System.out.println(sum(nums));
    }
    private static int sum(int[] nums){
        int n=nums.length;
        long[]prefixSum=new long[n];
        long[]suffixSum=new long[n];
        long[]totalSum=new long[n+1];
        long[]cout=new long[n+1];
        prefixSum[0]=nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i]=(prefixSum[i-1]+nums[i])%mod;
        }

        suffixSum[n-1]=nums[n-1];
        for (int i = n-2; i>=0 ; i--) {
            suffixSum[i]=(suffixSum[i+1]+nums[i])%mod;
        }
        for (int i = 0; i < n; i++) {
            totalSum[i+1]=(totalSum[i]+(prefixSum[i]+suffixSum[i])%mod)%mod;
            cout[i+1]=(cout[i]+1)%mod;
        }
        long ans=0;
        for (int i = 0; i <=n ; i++) {
            ans=(ans+totalSum[i]/(cout[i]-1))%mod;
        }
        return (int)ans;
    }

    private static int dp(int index,int sum,int count,int[]nums){
        if (index==nums.length){
            return sum*count%mod;
        }
        int l=dp(index+1,sum+nums[index],count+1,nums)%mod;
        int r=dp(index+1,sum,count,nums)%mod;
        return (l+r)%mod;
    }
}
