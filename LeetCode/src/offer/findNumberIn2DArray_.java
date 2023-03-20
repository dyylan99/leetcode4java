package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/15 11:27
 * @description
 * 剑指 Offer 04. 二维数组中的查找
 **/
public class findNumberIn2DArray_ {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从右上角开始寻找: 小就往左,大就往下
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int i=0;
        int j=col-1;
        while (i<row&&j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
