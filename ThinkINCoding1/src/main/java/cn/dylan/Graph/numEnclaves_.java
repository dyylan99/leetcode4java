package cn.dylan.Graph;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 14:36
 * @description 1020. 飞地的数量
 **/
public class numEnclaves_ {
    public int numEnclaves(int[][] grid) {
        int res=0;
        //首先从上,下边界出发
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid,0,j);
            dfs(grid, grid.length-1,j);
        }
        //从左右边界出发
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length-1);
        }
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                if (grid[i][j]==1){

                    res+=dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private int dfs(int[][]grid, int i, int j){
        if (i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        return dfs(grid,i,j+1)+dfs(grid,i+1,j)+ dfs(grid,i-1,j)+dfs(grid,i,j-1)+1;
    }

}
