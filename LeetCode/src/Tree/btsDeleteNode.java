package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/25 15:03
 * @description 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *  450. 删除二叉搜索树中的节点
 **/
public class btsDeleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 有以下五种情况：
         *
         * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
         * 找到删除的节点
         * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
         * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
         * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
         * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
         */
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            //第二大类情况:
            //第二种情况
            if(root.left==null&root.right==null){
                return null;
            }
            //第四种情况
            if(root.right==null){
                return root.left;
            }
            //第三种情况
            if(root.left==null){
                return root.right;
            }
            //第五种情况
            TreeNode tem=root.right;
            //找到该右节点的最左边的节点
            while (tem.left!=null){
                tem=tem.left;
            }
            root.val=tem.val;
            root.right=deleteNode(root.right,tem.val);
        }
        return root;
    }
    /**
     * 迭代法:删除二叉搜索树的方式
     */
    //找到删除节点,并且将其左子树添加到其右子树的最左边节点上
    TreeNode deleteOneNode(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.right==null){
            return root.left;
        }
        //root的右子树不为空
        TreeNode cur=root.right;
        while (cur.left!=null){
            cur=cur.left;
        }
        cur.left=root.left;
        return root.right;
    }
    public TreeNode deleteNode2(TreeNode root, int key){
        if (root==null){
            return null;
        }
        TreeNode cur=root;
        TreeNode pre = null;
        //找到需要删除的节点的位置
        while (cur!=null){
           if(cur.val==key){
               break;
           }
           pre=cur;
           if(cur.val>key){
               cur=cur.left;
           }
           else{
               cur=cur.right;
           }
        }
        //只有一个节点就找到了目标删除节点说明根节点就是需要删除的节点
        if(pre==null){
            return deleteOneNode(root);
        }
        //通过pre知道删除的是左孩子还是右孩子
        if(pre.left!=null&&pre.left.val==key){
            pre.left=deleteOneNode(pre.left);
        }
        if(pre.right!=null&&pre.right.val==key){
            pre.right=deleteOneNode(pre.right);
        }
        return root;
    }





    /**
     * 普通二叉树的删除方式
     */
    public TreeNode normalTreeDel(TreeNode root,int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            //当目标节点的左右子树均不为零时
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.val = cur.val;
        }
        root.left=normalTreeDel(root.left,key);
        root.right=normalTreeDel(root.right,key);
        return root;
    }


}
