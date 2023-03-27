package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 13:36
 * @description TODO
 **/
public class copyRandomList_ {
    Map<Node1,Node1>cacheMap=new HashMap<>();
    public Node1 copyRandomList(Node1 head) {
        if(head==null){
            return null;
        }
        if(!cacheMap.containsKey(head)){
            Node1 headNew=new Node1(head.val);
            cacheMap.put(head,headNew);
            headNew.next=copyRandomList(head.next);
            headNew.random=copyRandomList(head.random);
        }
        return cacheMap.get(head);
    }
}

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
