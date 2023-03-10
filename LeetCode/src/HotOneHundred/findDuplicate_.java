package HotOneHundred;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/10 13:36
 * @description 287. 寻找重复数
 **/
public class findDuplicate_ {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }

    @Test
    public void test(){
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
