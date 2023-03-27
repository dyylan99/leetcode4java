package offer;

import java.util.ArrayList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 16:19
 * @description 剑指 Offer 41. 数据流中的中位数
 **/
public class MedianFinder {
    int len;
    boolean isOu;
    int index;
    ArrayList<Integer> a;
    public MedianFinder() {
        len=0;
        index=-1;
        a = new ArrayList<Integer>();
        isOu = true;
    }

    public void addNum(int num) {
        int l=0, r=len-1;
        while (l<=r) {
            int mid = (l+r)/2;

            if (a.get(mid) > num) r = mid - 1;
            else l = mid + 1;
        }
        if (l >= len) a.add(num);
        else a.add(l, num);

        ++len;

        if (isOu) {isOu = false;
            ++index;
        } else { isOu = true;}
    }

    public double findMedian() {
        return isOu ? (a.get(index)+0.0+a.get(index+1))/2 : a.get(index)+0.0;
    }
}
