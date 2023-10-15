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
        //开始时的左边界: l=0,右边界r,上边界0,下边界 b
        int l=0,r=matrix[0].length-1,t=0,b= matrix.length-1;
        for (;;){
            //从左到右
            for (int i = l; i <=r ; i++) {
                res.add(matrix[t][i]);
            }
            //从左到右,消耗了最上面的一层,因此t需要自增,并且比较t和b的大小
            if (++t>b) break;
            //从上到下
            for (int i = t; i <=b ; i++) {
                res.add(matrix[i][r]);
            }
            //从上到下,消耗了最右边的一层,因此r需要自减,比较r和l的大小
            if (--r<l) break;
            //从右到左
            for (int i = r; i>=l ; i--) {
                res.add(matrix[b][i]);
            }
            //从右到左,消耗了最下面的一层,b自减,比较b和t的大小
            if (--b<t) break;
            //从下到上
            for (int i=b;i>=t;i--){
                res.add(matrix[i][l]);
            }
            //从下到上,消耗最左边的一层,l自增,比较l和r的大小
            if (++l>r) break;
        }
        return res;
    }
}
