package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 14:18
 * @description TODO
 **/
public class factorization_ {
    public ArrayList<ArrayList<Integer>> factorization (int n) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();

        List<Integer>list=new ArrayList<>();
        int i=2;
        while (i<=n){
            if(i==n){
                list.add(i);
                break;
            }else if(n%i==0){
                list.add(i);
                n=n/i;
            }else {
                i++;
            }
        }
        Collections.sort(list);
        ArrayList<Integer>tmp=new ArrayList<>();
        int pre=list.get(0);
        tmp.add(pre);
        tmp.add(1);
        int cur;
        for (int j = 1; j < list.size(); j++) {
            cur = list.get(j);
            if(cur==pre){
                tmp.set(1,tmp.get(1)+1);
            }else{
                pre=cur;
                res.add(tmp);
                tmp=new ArrayList<>();
                tmp.add(cur);
                tmp.add(1);
            }
        }
        res.add(tmp);
        return res;

    }
    @Test
    public void test(){
        System.out.println(factorization(24));
    }
}
