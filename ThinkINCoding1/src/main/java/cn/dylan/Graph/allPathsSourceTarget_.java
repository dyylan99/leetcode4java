package cn.dylan.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/13 15:28
 * @description 797. 所有可能的路径
 **/
public class allPathsSourceTarget_ {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>cnt=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        cnt.add(0);
        dfs(graph,0);
        return res;
    }

    public void dfs(int graph[][],int node){
        if (node== graph.length-1){
            res.add(new ArrayList<>(cnt));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            int nextNode=graph[node][i];
            cnt.add(nextNode);
            dfs(graph,nextNode);
            cnt.remove(cnt.size()-1);
        }
    }
}
