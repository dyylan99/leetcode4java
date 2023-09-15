package cn.dylan.Graph;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/14 14:20
 * @description TODO
 **/
public class maxAreaOfIsland_ {
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    int area=0;
                    area+=dfs(grid,i,j);
                    res=Math.max(area,res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][]grid,int x, int y){
        if (x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0){
            return 0;
        }
        grid[x][y]=0;

        return dfs(grid,x,y+1)+dfs(grid,x+1,y)+ dfs(grid,x-1,y)+dfs(grid,x,y-1)+1;
    }
}
