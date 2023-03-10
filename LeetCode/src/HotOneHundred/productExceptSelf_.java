package HotOneHundred;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/10 13:09
 * @description TODO
 **/
public class productExceptSelf_ {
    public int[] productExceptSelf(int[] nums) {
        int[]answer=new int[nums.length];
        int left=1;
        int right=1;
        int len=nums.length;
        Arrays.fill(answer,1);
        for (int i = 0; i < nums.length; i++) {
            answer[i]*=left;

            left*=nums[i];

            answer[len-i-1]*=right;

            right*=nums[len-1-i];
        }
        return answer;
    }

    @Test
    public void test(){
        int[] ints = productExceptSelf(new int[]{1, 2, 5, 6, 7, 11});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
