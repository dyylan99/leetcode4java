package Array;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/6/19 18:31
 * @description 27. 移除元素
 **/
public class removeElement_ {
    public int removeElement(int[] nums,int val){
        //双指针法:
        int slow=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
