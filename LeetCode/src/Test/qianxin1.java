package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/9 15:40
 * @description 打家劫舍环形房屋
 **/
public class qianxin1 {
    public int maximizeDonations (int[] donations) {
        // write code here
        int n=donations.length;
        if(n==1){
            return donations[0];
        }
        int r1=getMaxValue(donations,0,n-2);
        int r2=getMaxValue(donations,1,n-1);
        return Math.max(r1,r2);
    }
    private int getMaxValue(int[]nums,int s,int e){
        if (s==e){
            return nums[s];
        }
        int n=nums.length;
        int[]dp=new int[n];
        dp[s]=nums[s];
        dp[s+1]=Math.max(nums[s],nums[s+1]);
        for (int i = s+2; i <=e ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[e];
    }
}
