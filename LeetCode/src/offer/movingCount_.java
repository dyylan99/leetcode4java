package offer;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/1 13:19
 * @description 面试题13. 机器人的运动范围
 **/
public class movingCount_ {
    public int movingCount(int m, int n, int k) {
            if(k==0){
                return 1;
            }
            boolean[][]isVisited=new boolean[m][n];
            return dfs(0,0,m,n,k,isVisited);
        }

        private int dfs(int i,int j,int m,int n,int k,boolean[][]isVisited){
            if(i<0||i>=m||j<0||j>=n||(i/10 + i%10 + j/10 + j%10)>k||isVisited[i][j]){
                return 0;
            }
            isVisited[i][j]=true;
            return dfs(i + 1, j, m, n, k, isVisited) + dfs(i - 1, j, m, n, k, isVisited) +
                    dfs(i, j + 1, m, n, k, isVisited) + dfs(i, j - 1, m, n, k, isVisited) + 1;
        }



}
