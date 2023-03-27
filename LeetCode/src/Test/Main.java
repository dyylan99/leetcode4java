package Test;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

            //n个数
            int n = sc.nextInt();
            //要操作的数
            long[]nums=new long[n];
            for (int i = 0; i < n; i++) {
                nums[i]=sc.nextLong();
            }
            //操作次数
            int count=sc.nextInt();
            //0->左端点
            //1->右端点

            int[][]matrix=new int[count][2];
            //左端点
            for (int i = 0; i < count; i++) {
                matrix[i][0]=sc.nextInt();
            }
            //右端点
            for (int i = 0; i < count; i++) {
                matrix[i][1]=sc.nextInt();
            }
            String M = sc.next();
            sc.nextLine();
            long[]XNums=new long[count];
            for (int i = 0; i < XNums.length; i++) {
                XNums[i]=sc.nextLong();
            }


            for (int i = 0; i < count; i++) {
                int l=matrix[i][0];
                int r=matrix[i][1];
                xOperation(nums,M.charAt(i),XNums[i],l-1,r-1 );
            }
        for (long num : nums) {
            System.out.print(num);
        }

    }
    public static void xOperation(long[] nums,char o,long x,int start,int end){
        if(o=='='){
            for (int j = start; j <=end ; j++) {
                if(j==nums.length){
                    break;
                }
                nums[j]=x;
            }
        }else if(o=='|'){
            for (int j = start; j <=end ; j++) {
                if(j==nums.length){
                    break;
                }
                nums[j]|=x;
            }
        }else{
            for (int j = start; j <=end ; j++) {
                if(j==nums.length){
                    break;
                }
                nums[j]&=x;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(8|3);
    }


}
