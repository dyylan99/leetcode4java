package OneToTwenty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/22 11:49
 * @description TODO
 **/
public class three {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int [] index=new int[128];
        for (int i = 0; i <index.length; i++) {
            index[i]=-1;
        }
            int start=0,res=0;
            for(int i=0;i<s.length();i++){
                int l=s.charAt(i);
                if((index[l]+1)>start){
                    start=index[l]+1;
                }
                if(res<(i-start+1)){
                    res=i-start+1;
                }
                index[l]=i;
            }
            return res;

    }

}
