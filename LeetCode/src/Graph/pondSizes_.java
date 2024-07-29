package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/5/19 11:28
 * @description
 * 面试题 16.19. 水域大小
 **/
public class pondSizes_ {
    public int[] pondSizes(int[][] land) {
        List<Integer>res=new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j]==0){
                    res.add(dfs(land,i,j));
                }
            }
        }
        res.sort(Comparator.comparingInt(a -> a));
        int[]ans=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=res.get(i);
        }
        return ans;

    }
    private int dfs(int[][]len,int i,int j){
        if (i<0 || j<0 || i>=len.length || j>=len[0].length || len[i][j]!=0){
            return 0;
        }
        //标记
        len[i][j]=-1;
        int size=1;
        for (int k = -1; k<=1; k++) {
            for (int l = -1; l <=1 ; l++) {
                size+=dfs(len,i+k,j+l);
            }
        }
        return size;
    }
}
