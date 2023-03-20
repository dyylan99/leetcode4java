package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/16 14:07
 * @description 剑指 Offer 12. 矩阵中的路径
 **/
public class exist_ {
                                    // 右    左     上      下
    private int[][]direct=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,chars,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][]board,char[] chars,int x,int y,int cur){
        if(cur>=chars.length){
            return true;
        }
        if(!isValid(board.length,board[0].length,x,y)){
            return false;
        }
       if(board[x][y]!=chars[cur]){
           return false;
       }
       //标记已经遍历过
       board[x][y]='0';
       boolean res=false;
        for (int[] ints : direct) {
            res|=dfs(board,chars,x+ints[0],y+ints[1],cur+1);
        }
        //回溯
        board[x][y]=chars[cur];
        return res;
    }

    public boolean isValid(int row,int col,int x,int y){
        if(x<row&&x>=0&&y<col&&y>=0){
            return true;
        }else{
            return false;
        }
    }
}
