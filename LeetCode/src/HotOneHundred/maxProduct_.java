package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/7 11:49
 * @description TODO
 **/
public class maxProduct_ {
    public int maxProduct(int[] nums) {
        /**
         * 由于存在负数,所以需要维护最大值和最小值(最小值最小值也有可能变成最大值)
         */
        int res=nums[0];
        if(nums.length==1){
            return res;
        }
        int tem1=res;
        int tem2=res;
        for (int i = 1; i < nums.length; i++) {
            //最大值
            int a=Math.max(nums[i],Math.max(tem1*nums[i],tem2*nums[2]));
            //最小值
            int b=Math.min(nums[i],Math.min(tem1*nums[i],tem2*nums[i]));
            res=Math.max(res,a);
            tem1=a;
            tem2=b;
        }
        return res;
    }
}
