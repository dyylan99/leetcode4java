package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/2 10:14
 * @description 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 48. 旋转图像
 **/
public class rotate_ {
    public void rotate(int[][] matrix) {
        //先水平翻转
        int n=matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tem=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=tem;
            }
        }
        //再沿主对角先翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tem=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tem;
            }
        }
    }
}
