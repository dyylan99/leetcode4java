package HotOneHundred;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/7 10:07
 * @description 146. LRU 缓存
 **/
//可以继承LinkedHashMap实现本题,也可以用双向链表加上hash的方式完成
public class LRUCache  {
    class DLinkedQueue{
        int key;
        int value;
        DLinkedQueue pre;
        DLinkedQueue next;

        public DLinkedQueue() {
        }

        public DLinkedQueue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedQueue>map=new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedQueue head,tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        head=new DLinkedQueue();
        tail=new DLinkedQueue();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        DLinkedQueue node = map.get(key);
        if (node==null) {
            return -1;
        }
        //重新放到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedQueue node = map.get(key);
        if(node==null){
            //key不存在,创建新的节点
            DLinkedQueue newNode = new DLinkedQueue(key, value);
            //添加进hash表
            map.put(key,newNode);
            //添加到双向链表的头部
            addToHead(newNode);
            //判断是否需要删除元素
            ++size;
            if(size>capacity){
                //移除链表尾部元素
                DLinkedQueue removeTail = removeTail();
                //删除hash中的该元素
                map.remove(removeTail.key);
                --size;
            }else {
                //如果key存在,移到首部
                node.value=value;
                moveToHead(node);
            }
        }
    }

    private void addToHead(DLinkedQueue node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    private void removeNode(DLinkedQueue node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private void moveToHead(DLinkedQueue node){
        removeNode(node);
        addToHead(node);
    }
    private DLinkedQueue removeTail(){
        DLinkedQueue res=tail.pre;
        removeNode(res);
        return res;
    }
}
