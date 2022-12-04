package BackTracking;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/4 17:39
 * @description 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * 332. 重新安排行程
 **/
public class findItinerary__ {

    private Deque<String> res;
    //map映射的是:起点-->该终点出现的次数,并且按终点名称的自然排序将顺序排好
    private Map<String, Map<String, Integer>> map;

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    //最后直接在第一次找到符合的res就直接在第一层返回了
                    //因为使用了TreeMap的缘故,第一次找到的res就是最优规划
                    if(backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            //若map包含这个起点,就直接取出value赋值给temp,temp再将出现次数加一
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                //不包含的话直接赋值出现次数为1
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    @Test
    public void test(){
        ArrayList<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("JFK","SFO")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK","ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO","ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL","JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL","SFO")));
        List<String> list = findItinerary(tickets);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
