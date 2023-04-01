package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 19:10
 * @description TODO
 **/
public class constructArr_ {
    public int[] constructArr (int[] a) {
        int[]res=new int[a.length];

        for (int i = 0,tmp=1; i <a.length ;tmp*=a[i],i++) {
            res[i]=tmp;
        }

        for (int i = a.length-1,tmp=1; i>=0 ;tmp*=a[i],i--) {
            res[i]*=tmp;
        }

        return res;

    }
}
