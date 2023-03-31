package Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 19:10
 * @description 1-n所有正整数都出现,且只出现一次, 每个排列第一个元素默认为好元素
 **/
public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n==1){
            System.out.println(1);
        }
        int[]nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        build(nums,k);
        for (int num : nums) {
            System.out.println(num+" ");
        }
    }
    //构造好元素数组,使其长为n,好元素个数为k
    public static void build(int[]nums,int k){
        if(k==1){
            reverse(nums);
        }
        int index1=0;
        int index2=1;
        if (k>=nums.length/2){
           while (index2<nums.length-1){
               swap(nums,index1,index2);
               index1+=2;
               index2+=2;
           }
        }
    }

    public static void reverse(int[]nums){
        int index1=0;
        int index2=nums.length-1;
        while (index2>index1){
            swap(nums, index1, index2);
            index1++;
            index2--;
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp1= nums[index1];
        nums[index1]= nums[index2];
        nums[index2]=tmp1;
    }

    //给定一个数组,计算好元素的个数
    public static int getCount(int[]nums){
        int count=1;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        pq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>pq.peek()){
                count++;
            }
            pq.add(nums[i]);
        }
        return count;
    }
}
