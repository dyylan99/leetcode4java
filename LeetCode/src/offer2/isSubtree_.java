package offer2;
import Tree.TreeNode;
/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/18 15:26
 * @description TODO
 **/
public class isSubtree_ {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root,subRoot)){
            return true;
        }
        boolean left=false;
        boolean right=false;
        if (root.left!=null){
            left=isSubtree(root.left,subRoot);
        }
        if (root.right!=null){
            right=isSubtree(root.right,subRoot);
        }

        return left||right;
    }


    public boolean isSameTree(TreeNode cur,TreeNode sub){
        if (cur==null&&sub==null){
            return true;
        }else if(cur==null){
            return false;
        }else if(sub==null){
            return false;
        }else {
            //都不为null
            if (sub.val==cur.val){
                return isSameTree(cur.left,sub.left)&&isSameTree(cur.right,sub.right);
            }else {
                return false;
            }
        }
    }

}
