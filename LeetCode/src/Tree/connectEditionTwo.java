package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 17:57
 * @description 给定一个二叉树
 *
 * struct Node {
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
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii
 * 117. 填充每个节点的下一个右侧节点指针 II
 **/
public class connectEditionTwo {
    public Node1 connect(Node1 root) {
        /**
         *借助队列层序遍历:
         * 但要注意的是最好创建cur和next,这样可以降低空间复杂度
         */
        Queue<Node1> q=new LinkedList<>();

        if(root!=null){
            q.add(root);
        }
        while (!q.isEmpty()){
            int size=q.size();
            Node1 cur=q.remove();
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
            for (int i = 1; i < size; i++) {
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
    public Node1 connect1(Node1 root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        //先遍历右子树的原因是:左子树连接时需要用到右子树的连接信息,
        //若右子树的连接未完成则左子树的连接也会出现问题:
        // 先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
        // 需要 root.left.next 下的节点的信息，若 root.right 下的节点未完全连
        // 接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
        // 返回错误的信息。可能出现的错误情况如下图所示。此时，底层最左边节点将无
        // 法获得正确的 next 信息：
        //                  o root
        //                 / \
        //     root.left  o —— o  root.right
        //               /    / \
        //              o —— o   o
        //             /        / \
        //            o        o   o
        connect1(root.right);
        connect1(root.left);
        return root;
    }

    /**
     * 先寻找当前节点的子节点,若找不到则找当前节点的next的子节点
     * @param root
     * @return
     */
    public Node1 getNext(Node1 root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}
