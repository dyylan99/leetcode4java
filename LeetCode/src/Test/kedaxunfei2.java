package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 20:02
 * @description TODO
 **/
public class kedaxunfei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        int k = in.nextInt();
        //构造排列:
        int []nums=new int[n];
        for (int i = 0; i<n; i++) {
            nums[i]=n-i;
        }
        rearrange(nums,0,k-1);

        for (int j = 0; j < nums.length; j++) {
            if (j==nums.length-1){
                System.out.print(nums[j]);
            }else{
                System.out.print(nums[j]+" ");
            }

        }


    }

    public static void rearrange(int[]nums,int start,int end){
        while (start<end){
            int t=nums[start];
            nums[start]=nums[end];
            nums[end]=t;
            start++;
            end--;
        }
    }
}
