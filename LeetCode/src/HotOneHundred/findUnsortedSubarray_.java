package HotOneHundred;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/14 13:16
 * @description 581. 最短无序连续子数组
 **/
public class findUnsortedSubarray_ {
    public int findUnsortedSubarray1(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        class Pair{
            int value;
            int index;

            public Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
        Stack<Pair>s1=new Stack<>();
        Stack<Pair>s2=new Stack<>();
        s1.add(new Pair(nums[0],0));
        s2.add(new Pair(nums[nums.length-1],nums.length-1));
        int index=1;
        int index2=nums.length-2;
        int left=0;
        int right=nums.length-1;
        while (index<nums.length&&!s1.empty()){
            if(nums[index]>=s1.peek().value){
                s1.add(new Pair(nums[index],index));
                index++;
                //一旦有一个元素不符合递增条件,那么就不能继续增加元素
            }else{
                s1.pop();
                //当s1不为空时
                while (!s1.empty()&&index<nums.length){
                    if(s1.peek().value<=nums[index]){
                        index++;
                        continue;
                    }else {
                        s1.pop();
                    }
                }
            }
        }
        while (index2>=0&&!s2.empty()){
            if(nums[index2]<=s2.peek().value){
                s2.add(new Pair(nums[index2],index2 ));
                index2--;
                //一旦有一个不符合连续递减,那么接下来就不能再往栈里添加元素
                //继续遍历接下来的元素,检查是否有比当前栈更大的元素
            }else{
                s2.pop();
                while (!s2.empty()&&index2>=0){
                    //如果index2小于当前值,那么继续向前遍历数组
                    if(nums[index2]<=s2.peek().value){
                        index2--;
                        continue;
                        //index2大于当前值,那么将栈中的元素推出
                    }else{
                        s2.pop();
                    }
                }
            }
        }
        if(!s1.empty()){
            left=s1.peek().index+1;
        }
        if(!s2.empty()){
            right=s2.peek().index-1;
        }
        return right-left+1>0?right-left+1:0;

    }

    //简化版本
    public int findUnsortedSubarray(int[] nums){
        if(nums.length<2){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int L=0;
        int R=0;
        //从左往右遍历,比动态最大值小的值,并且更新index
        //最终就是找到需要的index
        for (int i = 0; i < nums.length; i++) {
            if(max>nums[i]){
                R=i;
            }
            max=Math.max(max,nums[i]);
        }
        //从右往左遍历,找到最小值
        for (int i = nums.length-1; i >=0 ; i--) {
            if (min<nums[i]){
                L=i;
            }
            min=Math.min(min,nums[i]);
        }

        return L==R?0:R-L+1;
    }
    @Test
    public void test(){
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
