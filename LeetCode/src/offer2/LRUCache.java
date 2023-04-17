package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/17 17:47
 * @description TODO
 **/
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    int capacity;
    Map<Integer,Node>map;
    int size;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node==null){
            return -1;
        }
        //重新放到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node==null){
            //key不存在
            Node cur=new Node(key,value);
            map.put(key,cur);
            addToHead(cur);
            ++size;
            if (size>capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        }else{
            //更新
            node.value=value;
            moveToHead(node);
        }
    }

    /**
     * 辅助方法
     */
    private Node removeTail(){
        if (tail.pre==head){
            //为空,不需要移除
            return null;
        }
       Node node=tail.pre;
        removeNode(node);
        return node;
    }
    private void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private void addToHead(Node node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    private void moveToHead(Node node){
        //首先移除
        removeNode(node);
        //添加到head
        addToHead(node);
    }

}
