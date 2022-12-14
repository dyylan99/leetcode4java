package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/14 15:08
 * @description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 **/
public class uniquePathsWithObstacles_ {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1){
            return 0;
        }
        int[][]dp=new int[m][n];
        for (int i = 0; i < m&&obstacleGrid[i][0]==0; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n&&obstacleGrid[0][i]==0; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int i1 = 1; i1 < n; i1++) {
                dp[i][i1]=(obstacleGrid[i][i1]==0)?dp[i-1][i1]+dp[i][i1-1]:0;
            }
        }
        return dp[m-1][n-1];
    }
}
