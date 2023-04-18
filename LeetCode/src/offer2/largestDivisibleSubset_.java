package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 15:52
 * @description TODO
 **/
public class largestDivisibleSubset_ {
    public List<Integer>largestDivisibleSubset(int[]nums){
        Arrays.sort(nums);
        //从零开始至 nums 下标为 i 的元素，可以形成最大长度为 subsetLength[i] 整除的子集
        int[]subsetLen=new int[nums.length];

        int maxIndex=0;

        for (int i = 0; i < nums.length; i++) {
            subsetLen[i]=1;
            for (int j = 0; j <i ; j++) {
                if (nums[i]%nums[j]==0){
                    subsetLen[i]=Math.max(subsetLen[i],subsetLen[j]+1);
                }
            }
            if (subsetLen[i]>subsetLen[maxIndex]){
                maxIndex=i;
            }
        }

        //根据已取得的 最大子集中的最大元素（maxNum）和其长度 maxLength 推导出最大子集
        List<Integer>maxSubSet=new ArrayList<>();

        maxSubSet.add(nums[maxIndex]);
        for (int i = nums.length-1; i>=0&&subsetLen[maxIndex]>1 ; i--) {
            //是maxIndex前一个元素
            if ((subsetLen[maxIndex]-1==subsetLen[i])&&nums[maxIndex]%nums[i]==0){
                maxSubSet.add(nums[i]);
                maxIndex=i;
            }
        }
        return maxSubSet;
    }
}
