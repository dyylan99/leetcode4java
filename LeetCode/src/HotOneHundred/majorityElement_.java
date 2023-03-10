package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/8 11:59
 * @description TODO
 **/
public class majorityElement_ {
    public int majorityElement(int[] nums) {
        /**
         * 利用快速排序的思想
         * 既然有一半以上的元素是相同的,那么就选定一个数然后把小于等于该数的放在左边,大于的放在右边
         */
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
