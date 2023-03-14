package HotOneHundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/13 13:40
 * @description 448. 找到所有数组中消失的数字
 **/
public class findDisappearedNumbers_ {
    //将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        List<Integer>res=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>1){
                res.add(i);
            }
        }
        return res;
    }
}
