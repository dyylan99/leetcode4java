package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/31 15:16
 * @description 给定二叉搜索树（BST）的根节点root和要插入树中的值value，
 * 将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 *701. 二叉搜索树中的插入操作
 **/
public class insertIntoBST_ {
    //递归方式
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            TreeNode node=new TreeNode(val);
            return node;
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
    //迭代方式
    public TreeNode insertIntoBST1(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode cur=root;
        TreeNode pre=null;
        while (cur!=null){
            pre=cur;
            if(cur.val<val){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        TreeNode node=new TreeNode(val);
        if(pre.val<val){
            pre.right=node;
        }else{
            pre.left=node;
        }
        return root;
    }
}
