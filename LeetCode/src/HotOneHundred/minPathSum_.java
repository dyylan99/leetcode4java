package HotOneHundred;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/2 10:29
 * @description 64. 最小路径和
 *
 *
 **/
public class minPathSum_ {
    public int minPathSum(int[][] grid) {
        //dp[i][j]为从起点到(i,j)的最短路径和
        int[][]dp=new int[grid.length][grid[0].length];
        //初始化:
        dp[0][0]=grid[0][0];
        //水平方向初始化:
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        //垂直方向初始化:
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //推导状态方程:
        /**
         *点(i,j)可以由(i-1,j)或者(i,j-1)到达
         * dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
         */
        for (int i = 1; i < grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    @Test
    public void test(){
        /**
         * 1,2,3
         * 4,5,6
         */
        int[][]test=new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(test));
    }
}
