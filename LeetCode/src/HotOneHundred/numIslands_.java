package HotOneHundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/9 10:50
 * @description TODO
 *
 * 200. 岛屿数量
 **/
public class numIslands_  {
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    //广度优先搜索
    private void bfs(char[][]grid,int x,int y){
        Queue<int[]>list=new LinkedList<>();

        list.add(new int[]{x,y});

        while (!list.isEmpty()){
            int[]cur=list.remove();
            x=cur[0];y=cur[1];
            //未越界且为1
            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]=='1'){
                grid[x][y]='0';
                list.add(new int[]{x+1,y});
                list.add(new int[]{x-1,y});
                list.add(new int[]{x,y+1});
                list.add(new int[]{x,y-1});
            }

        }
    }
    //深度优先搜索
    private void dfs(char[][]grid,int x,int y){
        if(x<0||y<0||x>grid.length||y>grid[0].length||grid[x][y]=='0'){
            return;
        }
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
