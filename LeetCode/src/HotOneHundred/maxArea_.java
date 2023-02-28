package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/27 11:04
 * @description
 * 11. 盛最多水的容器
 *
 *
 **/
public class maxArea_ {
    public int maxArea(int[] height) {
        /**
         * 双指针
         */
        int left=0;
        int right=height.length-1;
        int s=0;
        while (left<right){
            s=Math.max(s,area(left,right,height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return s;
    }

    public int area(int i,int j,int iHeight,int jHeight){
        return Math.min(jHeight,iHeight)*(j-i);
    }
}
