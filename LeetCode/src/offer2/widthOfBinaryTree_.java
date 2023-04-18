package offer2;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 14:35
 * @description TODO
 **/
public class widthOfBinaryTree_ {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode>queue=new ArrayDeque<>();
        int res=1;
        Map<TreeNode,Integer>map=new HashMap<>();
        map.put(root,1);
        if (root.left!=null){
            map.put(root.left,2);
            queue.add(root.left);
        }
        if (root.right!=null){
            map.put(root.right,3);
            queue.add(root.right);
        }

        while (!queue.isEmpty()){
            int size=queue.size();
            int left=0,right=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                //拿到第一个元素的位置
                if (i==0){
                    left = map.get(node);
                }
                if (i==size-1){
                    right=map.get(node);
                }
                if (node.left!=null){
                    queue.add(node.left);
                    map.put(node.left,map.get(node)*2);
                }
                if (node.right!=null){
                    queue.add(node.right);
                    map.put(node.right,map.get(node)*2+1);
                }
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }

    public int widthOfBinaryTree1(TreeNode root){

        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}
class Pair<T,V>{
    T key;
    V value;
    public Pair(T t,V v){
        this.key=t;
        this.value=v;
    }

    public T getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }


}
