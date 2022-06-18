package TreeTrain;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/13 16:41
 * @description 已知两颗二叉树，将它们合并成一颗二叉树
 * 。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 **/
public class mergeTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode res=new TreeNode(t1.val+t2.val);
        /**
         * 使用层序遍历的方式,对两棵树同时进行
         */
        //用来存放第一棵树遍历的结果
        Queue<TreeNode>q1=new LinkedList<>();
        //用来存放第二棵树遍历的结果
        Queue<TreeNode> q2=new LinkedList<>();
        //用来存放结果树遍历的结果
        Queue<TreeNode>q3=new LinkedList<>();

        q3.add(res);
        q1.add(t1);
        q2.add(t2);
        while(!q1.isEmpty()&&!q2.isEmpty()){
            //取出结果树队列的第一个值
            TreeNode work=q3.remove();

            TreeNode top = q1.remove();

            TreeNode bottom=q2.remove();

            TreeNode left1=top.left;

            TreeNode left2=bottom.left;

            TreeNode right1=top.right;

            TreeNode right2=bottom.right;
            //当第一棵树的左节点与第二棵树的左节点同时不为null时,
            // 分配给结果树新节点,将当前的节点的左节点的值赋值为新节点,
            // 新节点的值为1树2树左节点值之和
            if(left1!=null&&left2!=null) {
                TreeNode left=new TreeNode(left1.val + left2.val);
                work.left=left;
                q3.add(left);
              q1.add(left1);
              q2.add(left2);

            }else if(left1!=null){
                //若2树左节点为空,则可以直接将1树的左节点赋值给结果树的左节点
                    work.left=left1;
            }else{
                //同理
                work.left=left2;
            }
            //同理
            if(right1!=null&&right2!=null){
                TreeNode right=new TreeNode(right1.val+right2.val);
                work.right=right;
                q3.add(right);
                q1.add(right1);
                q2.add(right2);
            }else if(right1!=null){
                work.right=right1;
            }else{
                work.right=right2;
            }

        }
        return res;
    }
    /**
     * 使用前序遍历解决:
     */
    public TreeNode preOrder(TreeNode t1,TreeNode t2){
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode head=new TreeNode(t1.val+t2.val);
        head.left=preOrder(t1.left,t2.left);
        head.right=preOrder(t1.right,t2.right);
        return head;
    }
}
