package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 13:50
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 *
 *
 **/
public class treeToDoublyList_ {
    /**
     * 二叉搜索树的中序遍历就是一个递增的序列
     */
    //保存第一个节点
    Node first;
    //保存上一个节点
    Node pre;
    public Node treeToDoublyList(Node root){
        if(root==null){
            return null;
        }
        rec(root);
        first.left=pre;
        pre.right=first;
        return first;
    }
    private void rec(Node root){
        if (root==null){
            return;
        }
        //左
        rec(root.left);
        //根
        if (first==null){
            first=root;
            pre=first;
        }else{
            pre.right=root;
            root.left=pre;
            pre=root;
        }
        rec(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
