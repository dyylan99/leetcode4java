package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/5 13:06
 * @description 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
 *
 * 51. N皇后
 **/
public class solveNQueens__ {

    /**
     * 思路: 1. 建立一个n x n的二维字符数组作为棋盘,首先都填充 '.'
     *
     *2.写一个判断N皇后是否合法的方法:  同一列,同一行,45°,135°上是否有已经构建过的皇后
     *
     * 3.回溯
     *
     * */

    private List<List<String>>res=new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][]chessboard=new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars,'.');
        }
        backTracking(n,0,chessboard);
        return res;
    }


    void backTracking(int n,int row,char[][]chessboard){
        if(row==n){
            res.add(toList(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backTracking(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }

    }

    public List toList(char[][]chessboard){
        List<String>list=new ArrayList<>();

        for (char[]c:chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row,int col,int n,char[][]chessboard){
        for (int i = 0; i < row; ++i) {
            if(chessboard[i][col]=='Q'){
                return false;
            }

        }
        //检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

}
