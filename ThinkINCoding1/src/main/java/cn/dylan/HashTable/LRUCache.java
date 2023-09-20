package cn.dylan.HashTable;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 14:08
 * @description 146. LRU 缓存
 **/
public class LRUCache {
    static class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(){
            this.key=-1;
            this.val=-1;
        }
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private int capacity;
    private Map<Integer,Node>map;
    private int size;
    private Node dummyHead;
    private Node dummyTail;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        this.size=0;
        dummyHead=new Node();
        dummyTail=new Node();
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            unlinkNode(node);
            moveToHead(node);
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node==null){
            Node cur=new Node(key,value);
            map.put(key,cur);
            addHead(cur);
            size++;
            if (size>capacity){
                Node tail = removeTail();
            }
        }else{
            node.val=value;
            moveToHead(node);
        }
    }
    private void addHead(Node node){
        node.next=dummyHead.next;
        dummyHead.next.pre=node;
        dummyHead.next=node;
        node.pre=dummyHead;

    }
    private void moveToHead(Node node){
        unlinkNode(node);
        addHead(node);
    }

    private void removeNode(Node node){
       unlinkNode(node);
        size--;
    }
    private void unlinkNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private Node removeTail(){
        Node tail = dummyTail.pre;
        removeNode(tail);
        map.remove(tail.key);
        return tail;
    }



}
