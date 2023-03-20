package offer;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/19 13:56
 * @description 剑指 Offer 29. 顺时针打印矩阵
 **/
public class spiralOrder_ {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[]{};
        }
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         *
         *
         * 从右左->从上往下->从左往右->从下往上->
         * 不断更新矩阵的上下边界,防止重复遍历
         * 不然可能会重复遍历
         */
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int[] res = new int[total];
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        int nums = 0;
        while (left <= right && top <= bottom) {
            //从左往右
            for (int i = left; i <= right; i++) {
                res[nums++] = matrix[top][i];
            }
            //从上往下
            for (int i = top + 1; i <= bottom; i++) {
                res[nums++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                //从左往右
                for (int i = right-1; i>left; i--) {
                    res[nums++]=matrix[bottom][i];
                }
                //从下往上
                for (int i = bottom; i>top; i--) {
                    res[nums++]=matrix[i][left];
                }
            }
            //更新矩阵的上下左右边界,防止重复遍历
            //更新左边界
            left++;
            //更新右边界
            right--;
            //更新上边界
            top++;
            //更新下边界
            bottom--;
        }
        return res;
    }

    @Test
    public void test(){
        int[][]matirx=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = spiralOrder(matirx);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }
}
