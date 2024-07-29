package ArrayTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/29 23:04
 * @description 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 **/
public class findDuplicate_ {
    //解题关键: 由于所有的数字都在 [1, n] 范围内，但是有n+1个值,所以一定有重复值,例如:
    //值: 1 3 2 4 2
    //索引: 0 1 2 3 4
    // nums[0]=1      nums[1]=3      nums[3]=4   nums[4]=2  慢指针
    //nums[nums[0]]=3 nums[nums[3]]=2 nums[nums[2]]=2  nums[nums[2]]=2 快指针    因此: 这个循环在 [nums[2],4] 之间
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
