package HotOneHundred;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/9 12:15
 * @description TODO
 **/
public class findKthLargest_ {

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //小于0,o1排前面; 大于0,o1排后面
                return o2-o1;
            }
        });
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k-1; i++) {
            pq.remove();
        }
        return pq.remove();
    }


    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        int target=len-k;
        while (true){
            int partition = partition(nums, left, right);
            if(partition==target){
                return nums[partition];
            }else if(partition<target){
                left=partition+1;
            }else{
                right=partition-1;
            }
        }
    }

    //@Test
    //public void test(){
    //    System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));
    //}

    //找到第返回值大的元素
    public int partition(int[]nums, int left, int end){
        //给定范围最后一个数作为分割数
        int x=nums[end];
        //起始index为start-1, i是小于分割数的最大小标
        int i=left-1;
        for (int j = left; j <end ; j++) {
            //若小于分割数
            if(nums[j]<=x){
                //指针+1
                ++i;
                //将j位置的数换到i位置-->保证i位置之前的数都小于分割数
                swap(nums,i,j);
            }
        }
        //i+1位置为分割数
        swap(nums,i+1,end);
        //返回分割数所在位置
        return i+1;
    }

    public void swap(int[] nums,int x,int y){
       int tem=nums[x];
       nums[x]=nums[y];
       nums[y]=tem;

    }
}
