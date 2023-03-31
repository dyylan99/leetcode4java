package Test;

import java.util.ArrayList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/31 14:42
 * @description TODO
 **/
public class triangles_ {

    public int triangles (ArrayList<Point> points) {
        if(points.size()<=2){
            return 0;
        }
        int n=points.size();
        //int num=n*(n-1)*(n-2)/6;
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                for (int k = j+1; k <n ; k++) {
                   if(isOnOneLine(points.get(i),points.get(j),points.get(k))){
                       continue;
                   }
                   count++;
                }
            }
        }
        return count;
    }
    private boolean isOnOneLine(Point p1,Point p2,Point p3){
        return (p1.x- p2.x)*(p2.y- p3.y)==(p2.x- p3.x)*(p1.y- p2.y);
    }

}

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
