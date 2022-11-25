package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/23 19:52
 * @description 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 349 数组的交集
 **/
public class intersection_ {

    //使用set解决
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer>res=new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)){
                res.add(i);
            }
        }
        return res.stream().mapToInt(x->x).toArray();

    }


}
