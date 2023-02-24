package BackTracking;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/24 10:59
 * @description n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 52. N 皇后 II
 **/
public class totalNQueens_ {
    int count=0;

    public int totalNQueens(int n) {
        char[][]board=new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }
        backTrack(n,0,board);
        return count;
    }

    private void backTrack(int n,int row,char[][]board){
        if(row==n){
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(row,col,n,board)){
                board[row][col]='Q';
                backTrack(n,row+1,board);
                board[row][col]='.';
            }
        }
    }


    public boolean isValid(int row,int col,int n,char[][] board){
        //检查列
        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //检查45度角
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //检查135度角
        for (int i = row-1,j=col+1; i>=0&&j<=n-1; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
