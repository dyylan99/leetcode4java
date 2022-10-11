package Tree;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 17:16
 * @description 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 116. 填充每个节点的下一个右侧节点指针
 **/
public class connect_ {
    public Node1 connect(Node1 root) {
        /**
         * 思路, 采用层序遍历,因为是完美二叉树,所以若父节点有子节点则必有左右节点
         * 借助队列层序遍历
         * 按照队列的顺序依次添加填充next
         */
        /**
         * 该代码借助了2n个格外空间,遍历了一次二叉树,遍历了n次每层的元素,时间和空间复杂度都较差
         */
        if(root==null){
            return root;
        }
        Queue<Node1>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Node1>list=new ArrayList<>();
            int len=q.size();
            for (int i = 0; i < len; i++) {
                Node1 remove = q.remove();
                list.add(remove);
                if(remove.left!=null){
                    q.add(remove.left);
                }
                if(remove.right!=null){
                    q.add(remove.right);
                }
            }
            int listSize=list.size();
            for (int i = 0; i < listSize; i++) {
                if((i+1)<listSize){
                    list.get(i).next=list.get(i+1);
                }
            }
        }
        return root;
    }
    public Node1 connect1(Node1 root){
        Queue<Node1>q=new LinkedList<>();
        if(root!=null){
            q.add(root);
        }
        while (!q.isEmpty()){
            int size=q.size();
            Node1 cur=q.poll();
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
            for (int i = 1 ; i <size ; i++) {
                Node1 next=q.remove();
                if(next.left!=null){
                    q.add(next.left);
                }
                if(next.right!=null){
                    q.add(next.right);
                }
                cur.next=next;
                cur=next;
            }
        }
        return root;
    }
    //递归版本
    public Node1 connect2(Node1 root){
        /**
         * 暂停条件
         */
        if(root==null){
            return null;
        }
        //若根节点有孩子
        if(root.left!=null){
            root.left.next=root.right;
            //若根节点的next不为空
            if(root.next!=null){
                root.right.next=root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
