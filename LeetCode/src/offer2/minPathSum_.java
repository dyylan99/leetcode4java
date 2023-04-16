package offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/16 17:24
 * @description 剑指 Offer II 099. 最小路径之和
 **/
public class minPathSum_ {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j] 代表从起点到(i,j)的最小路径权重
        int dp[][] =new int[m][n];
        dp[0][0] = grid[0][0];
        //左侧第一列只能由上往下
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //第一行只能由左到右
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
    
        //其余点的最优目标 只要比较左边和上面的最优路径权重+该点权重
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
