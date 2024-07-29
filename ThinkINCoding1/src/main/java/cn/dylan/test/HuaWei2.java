package cn.dylan.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/16 15:46
 * @description TODO
 **/
public class HuaWei2 {
    public static void main(String[] args) {
        System.out.println(collis(new int[]{5,-1,-8,4,-5}));
    }

    private static List<Integer>collis(int[]nums){
        // 相同方向不会碰撞, 大碰小, 小的会消失, 相等体积会一起消失
        //-3,5,-1, -3,-5--> -3
        List<Integer>res=new ArrayList<>();
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        stack.add(nums[0]);
        for (int n = 1; n < nums.length; n++) {
            if ((nums[n]<0 && stack.peekLast()>0) ){
                Integer last = stack.pollLast();
                if (last>Math.abs(nums[n])){
                    stack.add(last);
                }else if(last<Math.abs(nums[n])){
                    stack.add(nums[n]);
                }else{
                    //直接弹出
                }
            }else{
                stack.add(nums[n]);
            }
        }
        for (Integer i : stack) {
            res.add(i);
        }
        return res;
    }
}
