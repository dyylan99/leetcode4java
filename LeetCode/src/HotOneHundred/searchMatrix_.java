package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/10 13:22
 * @description TODO
 * 240. 搜索二维矩阵 II
 **/
public class searchMatrix_ {
    public boolean searchMatrix(int[][] matrix, int target) {
        //最巧妙的解法: 从右上角开始搜索
        int len=matrix.length-1;
        int col=matrix[0].length-1;
        int lenStart=0;
        int colStart=col;
        while (lenStart<=len&&colStart>=0){
            if(target>matrix[lenStart][colStart]){
                lenStart++;
            }else if(target<matrix[lenStart][colStart]){
                colStart--;
            }else{
                return true;
            }
        }
        return false;
    }

    //用二分搜素
    public boolean searchMatrix1(int[][] matrix, int target) {
        boolean res = false;
        for (int[] ints : matrix) {
            res = searchMid(ints, target);
            if (res) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMid(int[]nums,int target){
        int len=nums.length;
        int left=0;
        int right=len-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
