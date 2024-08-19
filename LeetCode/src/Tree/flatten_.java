package Tree;

/**
 * @author panyuhang
 * @version 1.0
 * @description TODO
 * @since 2024/8/20 0:03
 **/
public class flatten_ {
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode next=cur.left;
                //找到左子树的最右节点
                TreeNode pre=next;
                while (pre.right!=null){
                    pre=pre.right;
                }
                //将cur的右子树的最右节点的右子树指向cur的右子树
                pre.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
}
