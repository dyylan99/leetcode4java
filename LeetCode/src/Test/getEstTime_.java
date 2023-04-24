package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/22 14:34
 * @description TODO
 **/
public class getEstTime_ {
    int res=Integer.MAX_VALUE;
    public int getEstTime (int[][] map, int a_x, int a_y, int b_x, int b_y) {
        // write code here
        boolean[][]isVisited=new boolean[map.length][map[0].length];
        traverse(map,a_x,a_y,b_x,b_y,isVisited,0);
        if (res==0){
            return -1;
        }
        if (res/2==0){
            return res/2;
        }else{
            return res/2+1;
        }
    }
    private void traverse(int[][]map,int a_x,int a_y,int b_x,int b_y,boolean[][]isVisited,int time){
        if (a_x==b_x&&a_y==b_y){
            if (res==0){
                res=time;
            }else{
                res=Math.min(res,time);
            }
        }
        if (a_x+1<map.length&&map[a_x+1][a_y]==1&&!isVisited[a_x+1][a_y]){
            isVisited[a_x+1][a_y]=true;
            traverse(map,a_x+1,a_y,b_x,b_y,isVisited,time+1);
            isVisited[a_x+1][a_y]=false;
        }
        if (a_y+1<map[0].length&&map[a_x][a_y+1]==1&&!isVisited[a_x][a_y+1]){
            isVisited[a_x][a_y+1]=true;
            traverse(map,a_x,a_y+1,b_x,b_y,isVisited,time+1);
            isVisited[a_x][a_y+1]=false;
        }
    }
}
