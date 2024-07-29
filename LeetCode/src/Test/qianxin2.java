package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/9 15:50
 * @description TODO
 **/
public class qianxin2 {
    public boolean CheckGameResource (int[] sequence) {
        // write code here
        return isEqual(sequence) && isValid(sequence);
    }
    private boolean isEqual(int[]nums){
        int c1=0,c2=0;
        for (int num : nums) {
            if(num==0){
                c1++;
            }else{
                c2++;
            }
        }
        return c1==c2;
    }

    private boolean isValid(int[]nums){
        int c1=0;
        for (int num : nums) {
            if (num==0){
                c1--;
            }else{
                c1++;
            }
            if (c1<0){
                return false;
            }
        }
        return true;
    }
}
