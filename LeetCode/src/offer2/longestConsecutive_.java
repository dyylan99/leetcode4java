package offer2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 22:56
 * @description TODO
 **/
public class longestConsecutive_ {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Set<Integer>set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max=1;
        for (int num : nums) {
            if (set.contains(num)){
                int left=num-1;
                int right=num+1;
                int count=1;
                while (set.contains(left)){
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)){
                    set.remove(right);
                    count++;
                    right++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
