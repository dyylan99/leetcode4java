package HotOneHundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/8 12:57
 * @description 207. 课程表
 *
 *
 **/
public class canFinish_ {
    List<List<Integer>>edges;
    int[] visited;
    boolean valid=true;
    //使用深度优先搜索
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            //初始化有向图
            edges.add(new ArrayList<>());
        }
        visited=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            //统计每个节点的出度信息
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses&&valid; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u){
        //搜到这个节点,但是还没有回溯完
        visited[u]=1;
        //学习u课程之后,
        for (Integer integer : edges.get(u)) {
            //没遍历过
            if(visited[integer]==0){
                //继续往下搜索
                dfs(integer);
                if(!valid){
                    return;
                }
            }else if(visited[integer]==1){
                valid=false;
                return;
            }
        }
        //遍历完了
        visited[u]=2;
    }


    //广度优先搜索
    int[]indeg;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //统计入度
            indeg[prerequisite[0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int visited=0;
        while (!q.isEmpty()){
            //修课程次数+1
            visited++;
            Integer remove = q.remove();
            for (Integer integer : edges.get(remove)) {
                //入度-1
                --indeg[integer];
                if(indeg[integer]==0){
                    //入度为0
                    q.add(integer);
                }
            }
        }
        return visited==numCourses;
    }
}
