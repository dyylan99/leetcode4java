package HotOneHundred;

import Tree.TreeNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/3 11:59
 * @description TODO
 *
 * 105. 从前序与中序遍历序列构造二叉树
 **/
public class buildTree_ {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return build(preorder,inorder,0,preorder.length,0,inorder.length);
    }

    //start为每次左子树首个节点的位置,end为最后一个左子树在preorder的索引
    public TreeNode build(int[] preorder,int[]inorder,int preStart, int preEnd,int inStart,int inEnd){
       if (preStart==preEnd){
        return null;
       }
       int rootValue=preorder[preStart];
       TreeNode root=new TreeNode(rootValue);
       if(preEnd-preStart==1){
           return root;
       }
       int delimiterIndex;
       for (delimiterIndex=inStart;delimiterIndex<inEnd;delimiterIndex++){
           if(inorder[delimiterIndex]==preorder[preStart]){
               break;
           }
       }
       //区间全是左闭右开
       int leftInorderBegin=inStart;
       int leftInorderEnd=delimiterIndex;
       int rightInorderBegin=delimiterIndex+1;
       int rightInorderEnd=inEnd;

       int leftPreorderBegin=preStart+1;
       //[)
       int leftPreorderEnd=preStart+delimiterIndex-inStart+1;
       //[)
       int rightPreorderBegin=leftPreorderEnd;
        int rightPreorderEnd=preEnd;
        root.left=build(preorder,inorder,leftPreorderBegin,leftPreorderEnd,leftInorderBegin,leftInorderEnd);
        root.right=build(preorder,inorder,rightPreorderBegin,rightPreorderEnd,rightInorderBegin,rightInorderEnd);

        return root;
    }

}
