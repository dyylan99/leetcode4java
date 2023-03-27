package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 15:34
 * @description TODO
 **/
public class majorityElement_ {
    public int majorityElement(int[] nums) {
        int cur=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==cur){
                count++;
            }else{
                count--;
                if(count==0){
                    cur=nums[i];
                    count=1;
                }
            }
        }
        return cur;
    }
}
