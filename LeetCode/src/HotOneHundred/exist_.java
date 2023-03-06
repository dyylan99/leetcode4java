package HotOneHundred;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/3 10:16
 * @description TODO
 **/
public class exist_ {
    private static final int[][]DIRECTIONS={{1,0},{-1,0},{0,1},{0,-1}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][]visited;
    private char[]charArray;
    private char[][]board;
    public boolean exist(char[][] board, String word) {
        /**
         *回溯:
         *
         */

        rows=board.length;
        if(rows==0){
            return false;
        }
        cols=board[0].length;
        charArray=word.toCharArray();
        this.board=board;
        visited=new boolean[rows][cols];
        len=word.length();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x,int y,int begin){
        if(begin==len-1){
            return board[x][y]==charArray[begin];
        }
        if(board[x][y]==charArray[begin]){
            visited[x][y]=true;
            for (int[] direction : DIRECTIONS) {
                int newX=x+direction[0];
                int newY=y+direction[1];
                if(inArea(newX,newY)&&!visited[newX][newY]){
                    if(dfs(newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            visited[x][y]=false;
        }
        return false;
    }
    private boolean inArea(int x,int y){
        return x>=0&&x<rows&&y>=0&&y<cols;
    }
}
