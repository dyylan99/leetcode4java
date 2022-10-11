package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 16:04
 * @description 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 429. N 叉树的层序遍历
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class nTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        /**
         * 思路:仍然借助队列来完成
         * 步骤和二叉树的层序遍历方式基本一致
         */
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int len=q.size();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i<len; i++) {
                Node cur=q.remove();
                int cLen=cur.children.size();
                for (int j = 0; j <cLen ; j++) {
                    q.add(cur.children.get(j));
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }
}
