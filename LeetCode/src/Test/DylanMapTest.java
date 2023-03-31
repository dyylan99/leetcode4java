package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 13:44
 * @description 自己模拟一个hashMap,但是没有红黑树
 **/
public class DylanMapTest<K,V>{
   static DylanMap<Integer,String>map=new DylanMap<>();
    static DylanMap<String,Object>map2=new DylanMap<>();
    public static void main(String[] args) {
        Integer i=1;
        System.out.println(map.put(i, "Dylan"));
        System.out.println(map.put(i, "Dylan1"));
        System.out.println(map.put(i, "Dylan2"));
        System.out.println(map.getVal(i));
        System.out.println(map.size);
        map2.put("Dylan",99);
        map2.put("Dylan2",98);
        map2.put("Dylan3",97);
        map2.put("Dylan4",99);
        System.out.println("map2:size: "+map2.size);

        map2.put(null,null);
        map2.put(null,2);

        System.out.println("map2:size: "+map2.size);
        System.out.println(map2.getVal(null));
    }
}

class DylanMap<K,V>{
    //元素个数
    int size;

    MapEntry<K,V>[]table;

    //hashMap是在使用时才初始化table的
    public DylanMap(){
        //桶的个数默认为16
        table=new MapEntry[16];
        size=0;
    }

    private V putVal(int hash,K key,V value){
        //到了这一步我们默认桶已经初始化好了
        int len=table.length;
        //hash值对模长取余得到桶下标
        int i=hash&(len-1);
        MapEntry<K, V> kvMapEntry = new MapEntry<>(hash, key, value, null);
        //先判断当前桶是否为空
        if(key!=null&&table[i]==null){
            table[i]=kvMapEntry;
            ++size;
            return kvMapEntry.value;
        }else{
            //不为空的话:,遍历是否存在,存在更新,不存在就插入
            MapEntry<K,V>node=table[i];
            //判断是否相等需要特别考虑key为null的时候
            if(node.hash==hash&&(Objects.equals(node.key, key))){
                node.value=value;
            }else{
                MapEntry<K,V>n=node.next;
                MapEntry<K,V>pre=node;
                while (n!=null){
                    if(!n.key.equals(key)){
                        n=n.next;
                        pre=pre.next;
                    }else {
                        //删除旧的node,重新插入到头部
                        pre.next=n.next;
                        table[i]=kvMapEntry;
                        kvMapEntry.next=node;
                        return value;
                    }
                }
                //说明当前链表不存在node
                //直接插入到头部
                ++size;
                table[i]=kvMapEntry;
                kvMapEntry.next=node;
            }
            return value;

        }

    }

    public V put(K key, V value){
        //计算key的hash
        return putVal(hash(key),key,value);
    }

    public V getVal(K key){
        int hash = hash(key);
        int i=hash&(table.length-1);

        MapEntry<K,V>node=table[i];
        while (node!=null){
            if(node.key==key||Objects.equals(node.key,key)){
                return node.value;
            }else{
                node=node.next;
            }

        }
        return null;
    }


    //返回key的hashCode
    public int hash(Object key){
        return (key == null) ? 0 :Objects.hashCode(key);
    }



    static class MapEntry<K,V>{

        final K key;

        final int hash;

        private V value;

        MapEntry<K,V>next;


        /**
         *
         * @param hash
         * @param key
         * @param value
         * @param next
         *
         * hashMap节点,hash冲突时使用头插法形成链表插入
         */
        public MapEntry(int hash,K key,V value,MapEntry<K,V>next){
            this.hash=hash;
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public final int hashCode(){
            //取key和value的hash值的异或
            return Objects.hashCode(key)^Objects.hashCode(value);
        }

    }

}
