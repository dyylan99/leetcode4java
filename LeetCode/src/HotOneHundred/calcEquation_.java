package HotOneHundred;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/12 11:28
 * @description TODO
 * 399. 除法求值
 **/
public class calcEquation_ {
    //public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
    //    class Pair{
    //        double value;
    //        String b;
    //
    //        public void setValue(double value) {
    //            this.value = value;
    //        }
    //
    //        public void setB(String b) {
    //            this.b = b;
    //        }
    //
    //        public Pair(double value, String b) {
    //            this.value = value;
    //            this.b = b;
    //        }
    //    }
    //    Map<String,Pair>map=new HashMap<>();
    //    //存放以b为除数的索引
    //    Map<String,List<Integer>>indexMap=new HashMap<>();
    //    double[] res=new double[queries.size()];
    //    //初始化hash
    //    for (int i = 0; i < equations.size(); i++) {
    //        //存在a/b 中的b
    //        String b = equations.get(i).get(1);
    //        String a = equations.get(i).get(0);
    //        //a,b都包含 那么修改一个值必然会引起其他值的改变
    //        if(map.containsKey(b)&&map.containsKey(a)){
    //            //map.put(a,values[i]*map.get(b));
    //            //更新a的值
    //            double value=map.get(b).value*values[i];
    //            map.put(a,new Pair(value,map.get(b).b));
    //            //更新以a为除数的pair
    //            List<Integer> list = indexMap.get(a);
    //            if(list!=null){
    //                for (Integer index : list) {
    //                    map.put(equations.get(index).get(0),new Pair(map.get(a).value*values[index],map.get(a).b));
    //                }
    //            }
    //
    //        }else if(map.containsKey(a)){
    //            //存在a/b中的a,不存在b
    //            //map.put(b,map.get(a)/values[i]);
    //            map.put(b,new Pair(map.get(a).value/values[i],map.get(a).b));
    //            ArrayList<Integer> list = new ArrayList<>();
    //            list.add(i);
    //            indexMap.put(b,list);
    //        }else if(map.containsKey(b)){
    //            //存在b,不存在a
    //            List<Integer> list = indexMap.get(b);
    //            list.add(i);
    //            map.put(a,new Pair(map.get(b).value*values[i],b));
    //        }
    //        else{
    //            //a,b都不包含
    //            ArrayList<Integer> list = new ArrayList<>();
    //            list.add(i);
    //            indexMap.put(b,list);
    //            map.put(b, new Pair(1.0,b));
    //            map.put(a,new Pair(values[i],b));
    //        }
    //    }
    //    for (int i = 0; i < queries.size(); i++) {
    //        //a,b都包含,且除数相同的话
    //        String a1 = queries.get(i).get(0);
    //        String b1 = queries.get(i).get(1);
    //        if(map.containsKey(a1)&&map.containsKey(b1)
    //                &&map.get(a1).b.equals(map.get(b1).b)){
    //            res[i]=map.get(a1).value/map.get(b1).value;
    //        }else{
    //            res[i]=-1.0;
    //        }
    //    }
    //    return res;
    //}
    List<Double>res=new ArrayList<>();

    //图，用哈希map来存节点关系和比值，比值存放在后一个节点里
    //<"a", ("b", 2.0)> 表示a/b=2.0
    Map<String, List<Pair>> map = new HashMap<>();
    //存储节点和对应比值
    class Pair{
        String val;
        double div;

        public Pair(){}

        public Pair(String val, double div){
            this.val = val;
            this.div = div;
        }
    }

    //标记当前问题是否有答案，用于在dfs中如果找到答案了就提前返回
    boolean isFound = false;

    //标记一次dfs中节点是否已经走过，走过的节点就加入set，回溯以后再去掉该节点
    Set<String> visited = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //构建图
        for(int i = 0; i < equations.size(); i++){
            List<Pair> list1 = map.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            list1.add(new Pair(equations.get(i).get(1), values[i]));
            //首次添加
            if(list1.size() == 1){
                map.put(equations.get(i).get(0), list1);
            }
            List<Pair> list2 = map.getOrDefault(equations.get(i).get(1), new ArrayList<>());
            list2.add(new Pair(equations.get(i).get(0), 1 / values[i]));
            //首次添加
            if(list2.size() == 1){
                map.put(equations.get(i).get(1), list2);
            }
        }
        //对queries中每个问题里的每个变量进行dfs
        for(int i = 0; i < queries.size(); i++){
            //图中没有该节点，结果直接置为-1
            if(!map.containsKey(queries.get(i).get(0))){
                res.add(-1.0);
                continue;
            }

            //每个新query开始前先重新置为false，说明还没找到答案
            isFound = false;

            //从当前变量节点开始dfs，注意标记节点是否走过
            visited.add(queries.get(i).get(0));
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
            visited.remove(queries.get(i).get(0));

            //从当前变量出发没有找到路径，结果-1.0（如果找到了isFound会为true）
            if(!isFound){
                res.add(-1.0);
            }

        }

        //放double数组里返回
        double[] r = new double[queries.size()];
        for(int i = 0; i < r.length; i++){
            r[i] = res.get(i);
        }

        return r;

    }
    public void dfs(String start,String target,double weight){
        if (isFound){
            return;
        }
        if(start.equals(target)){
            res.add(weight);
            isFound=true;
            return;
        }
        //遍历当前start的所有邻居
        for (Pair pair : map.get(start)) {
            if(visited.contains(pair.val)){
                continue;
            }
            visited.add(pair.val);
            dfs(pair.val, target,weight* pair.div);
            visited.remove(pair.val);
        }
    }
    @Test
    public void test(){
        List<List<String>>eq=new ArrayList<>();
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("e", "f");
        List<String> list3 = Arrays.asList("b", "e");
        eq.add(list1);
        eq.add(list2);
        eq.add(list3);
        double[]values=new double[]{3.4,1.4,2.3};

        List<List<String>>queries=new ArrayList<>();
        List<String> q1 = Arrays.asList("b", "a");
        List<String> q2 = Arrays.asList("a", "f");
        List<String> q3 = Arrays.asList("f", "e");
        queries.add(q1);
        queries.add(q2);
        queries.add(q3);

        double[] doubles = calcEquation(eq, values, queries);

        for (int i = 0; i < doubles.length; i++) {
            System.out.print(doubles[i]);
            System.out.print(" ,");
        }
    }
}
