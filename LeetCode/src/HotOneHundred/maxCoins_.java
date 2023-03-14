package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/11 12:58
 * @description 312. 戳气球
 **/
public class maxCoins_ {
    public int maxCoins(int[] nums) {
        //动态规划
        /**
         * dp[i][j]代表区间(i,j)能获得的最大硬币数
         *
         */
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];


    }
}
