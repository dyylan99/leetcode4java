package TreeTrain;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/10 10:11
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 *
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 **/
public class Convert {
    public TreeNode head;
    public TreeNode pre;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        /**
         * 方法一:递归中序遍历
         * 我们需要定义两个全局变量:一个head指向转换后的链表表头,一个pre指向当前链表节点的前驱节点
         * 1.判断是否是空树,若为空则返回null
         * 2.找到搜索树的最左最右的节点,为head赋值为最小节点,pre也初始化赋值
         * 3.找到当前节点的父节点(当前节点),pre的右子树节点指向父节点,父节点的左子树节点指向pre,pre赋值为父节点
         * 4.找到父节点(当前节点)的右子树,重复上述操作
         */
        if(pRootOfTree==null){
            return null;
        }
        //找到最左边的节点
        Convert1(pRootOfTree.left);
        //若pre未被赋值,则说明是第一次找到当前的最左节点,该节点应为表头
        if(pre==null){
            head=pRootOfTree;
            pre=pRootOfTree;
        }else{
            //若pre已被赋值,说明链表的头结点已被遍历过,则接下来实现双向链表的实现
            pre.right=pRootOfTree;
            pRootOfTree.left=pre;
            pre=pRootOfTree;
        }
        Convert1(pRootOfTree.right);
        return head;
    }
    /**
     * 方法二:使用深度优先搜索
     */
    public TreeNode convert(TreeNode root){
        if(root==null){
            return null;
        }
        Stack<TreeNode>s=new Stack<>();
        TreeNode p=root;
        TreeNode pre=null;
        boolean isFirst=true;
        /**
         * 总览下个while，可以看出遍历的顺序为左--》根--》右
         */
        while(p!=null||!s.empty()){
            /**
             * 此while负责找到每颗子树的最左边的节点
             */
            while(p!=null){
                s.push(p);
                p=p.left;
            }
            p=s.pop();
            if(isFirst){
                root=p;
                pre=root;
                isFirst=false;
            }else{
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            p=p.right;
        }
        return root;

    }

}
