package Tree;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/31 16:06
 * @description 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *538. 把二叉搜索树转换为累加树
 **/
public class convertBST_ {

    private int pre=0;
    public TreeNode convertBST(TreeNode root) {
       traversal(root);
       return root;
    }
    /**
     * 递归
     */
    public TreeNode traversal(TreeNode cur){
        if(cur==null){
            return null;
        }
        convertBST(cur.right);
        cur.val+=pre;
        pre=cur.val;
        convertBST(cur.left);
        return cur;
    }


    /**
     * 迭代: 二叉搜索树的从右向左遍历--->得到有序数组
     */
    public void traversal1(TreeNode cur){
        Stack<TreeNode>s=new Stack<>();
        //s.push(cur);
        while (cur!=null||!s.empty()){
            if(cur!=null){
                s.push(cur);
                cur=cur.right;
            }
            else{
                cur=s.pop();
                //s.pop();
                cur.val+=pre;
                pre=cur.val;
                cur=cur.left;
            }
        }
    }
}
