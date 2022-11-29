package ArrayTrain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/29 12:58
 * @description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 54. 螺旋矩阵
 **/
public class spiralOrder_ {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer>list=new LinkedList<>();
      if(matrix==null||matrix.length==0||matrix[0].length==0){
          return list;
      }
      int rows=matrix.length;
      int cols=matrix[0].length;
      int left=0;
      int right=cols-1;
      int top=0;
      int bottom=rows-1;
      while(left<=right&&top<=bottom){
          for(int column=left;column<=right;column++){
              list.add(matrix[top][column]);
          }
          for (int row=top+1;row<=bottom;row++){
              list.add(matrix[row][right]);
          }
          if(left<right&&top<bottom){
              for (int column=right-1;column>left;column--){
                  list.add(matrix[bottom][column]);
              }
              for (int row=bottom;row>top;row--){
                  list.add(matrix[row][left]);
              }
          }
          left++;
          right--;
          top++;
          bottom--;
      }
      return list;
    }
}
