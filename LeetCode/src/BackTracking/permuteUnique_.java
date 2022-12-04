package BackTracking;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/4 16:50
 * @description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 47. 全排列 II
 **/
public class permuteUnique_ {
    LinkedList<Integer>path=new LinkedList<>();

    List<List<Integer>>res=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int size=nums.length;
       boolean[]used=new boolean[8];
       Arrays.sort(nums);
        backTracking(nums,size,used);
        return res;
    }

    void backTracking1(int[]nums,int size,Map<Integer,Integer>map){
        if(path.size()==size){
            res.add(new ArrayList<>(path));
        }
        int[]used=new int[21];
        for (int i = 0; i < size; i++) {
            if (used[nums[i]+10]!=0||map.containsKey(i)){
                continue;
            }
            used[nums[i]+10]=1;
            map.put(i,nums[i]);
            path.add(nums[i]);
            backTracking1(nums,size,map);
            path.removeLast();
            map.remove(i);
        }
    }


    void backTracking(int[]nums,int size,boolean[]used){
        if(path.size()==size){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < size; i++) {
            if(i>0&&nums[i]==nums[i-1]&& used[i - 1]==false){
                continue;
            }
            if(used[i]==false){
                used[i]=true;
                path.add(nums[i]);
                backTracking(nums,size,used);
                path.removeLast();
                used[i]=false;
            }
        }
    }

}
