package BackTracking;

import Test.test1;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/5 14:11
 * @description 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 37. 解数独
 **/
public class solveSudoku__ {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    public boolean backTrack(char[][]board){
        for (int i=0;i<9;i++){
            for (int j =0; j < 9; j++) {
               if (board[i][j]!='.'){
                   continue;
               }
               for (char k='1';k<='9';k++){
                   if(isValid(board,j,i,k)){
                       board[i][j]=k;
                       if(backTrack(board)){
                           return true;
                       }
                       board[i][j]='.';
                   }
               }
               return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][]board,int col,int row,char value){
        //检查行
        for (int i = 0; i < 9; i++) {
            if(board[row][i]==value){
                return false;
            }
        }
        //检查列
        for (int i = 0; i < 9; i++) {
            if(board[i][col]==value){
                return false;
            }
        }
        //检查其3x3的正方形
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for (int i=startRow;i<startRow+3;i++){
            for (int j = startCol; j < startCol+3; j++) {
                if(board[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }

}


