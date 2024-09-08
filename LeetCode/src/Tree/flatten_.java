package Tree;

/**
 * @author panyuhang
 * @version 1.0
 * @description 二叉树展开为链表
 * @since 2024/8/20 0:03
 **/
public class flatten_ {
    //先序遍历: 先遍历根节点,再遍历左子树,最后遍历右子树
    //因此, 右子树在最后, 左子树次之, 根节点最先
    public void flatten(TreeNode root) {
        //根-左-右, 因此细节就是先找到能够衔接右子树的节点, 也就是左子树的最右节点
        if(root==null){
            return;
        }
        TreeNode cur=root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode next=cur.left;
                TreeNode pre=next;
                while (pre.right!=null){
                    pre=pre.right;
                }
                //pre为左子树的最右节点
                pre.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
}
