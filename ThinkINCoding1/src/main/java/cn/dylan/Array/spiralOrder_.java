package cn.dylan.Array;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 14:33
 * @description TODO
 **/
public class spiralOrder_ {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res=new ArrayList<>();
        int l=0,r=matrix[0].length-1,t=0,b= matrix.length-1;
        for (;;){
            for (int i = l; i <=r ; i++) {
                res.add(matrix[t][i]);
            }
            if (++t>b) break;

            for (int i = t; i <=b ; i++) {
                res.add(matrix[i][r]);
            }
            if (--r<l) break;

            for (int i = r; i>=l ; i--) {
                res.add(matrix[b][i]);
            }
            if (--b<t) break;
            for (int i=b;i>=t;i--){
                res.add(matrix[i][l]);
            }
            if (++l>r) break;
        }
        return res;
    }
}
