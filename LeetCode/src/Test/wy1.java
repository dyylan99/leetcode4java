package Test;

import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/23 14:02
 * @description TODO
 **/
public class wy1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            long []nums=new long[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j]=sc.nextLong();
            }
            System.out.println(ok(nums)?"YES":"NO");
        }
    }
    private static boolean ok(long[]nums){
        for (int i = 0; i < 2*nums.length; i++) {
            if (isok(nums)){
                return true;
            }
            if (nums[i%nums.length]>nums[(i+2)%nums.length]){
                swap(nums,i%nums.length,(i+2)%nums.length);
            }
        }
        return isok(nums)?true:false;
    }

    private static void swap(long[] nums,int i,int j){
        long tem=nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }

    private static boolean isok(long[] nums){
        long num=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<num){
                return false;
            }
            num=nums[i];
        }
        return true;
    }
}
