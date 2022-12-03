package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/3 14:59
 * @description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 46. 全排列
 **/
public class permute_ {
    List<List<Integer>>res=new ArrayList<>();

    LinkedList<Integer>path=new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[]used=new int[21];
        backTracking(nums,nums.length,used);
        return res;
    }

    void backTracking(int[] nums,int size,int[]used){
        if(path.size()==size){
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < size; i++) {
          if(used[nums[i]+10]==1){
              continue;
          }
           path.add(nums[i]);
            used[nums[i]+10]=1;
           backTracking(nums,size,used);
           path.removeLast();
           used[nums[i]+10]=0;
        }
    }

}
