package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/23 11:02
 * @description 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 100. 相同的树
 **/
public class isSameTree_ {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p,q);
    }
    boolean compare(TreeNode p,TreeNode q){
        if(p!=null&&q==null){
            return false;
        }else if(p==null&&q!=null){
            return false;
        }else if(p==null&&q==null){
            return true;
        }else if(p.val!=q.val){
            return false;
        }
        //此时是,左右节点都不为空,且值相同
        boolean left=compare(p.left,q.left);
        boolean right=compare(p.right,q.right);
        return left&&right;
    }
}
