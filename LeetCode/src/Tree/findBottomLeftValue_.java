package Tree;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/13 16:10
 * @description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 * 513. 找树左下角的值
 **/
public class findBottomLeftValue_ {
    /**
     * 递归使用的全局变量
     * @param root
     * @return
     */
    private int Deep=-1;
    private int value=0;

    public int findBottomLeftValue(TreeNode root) {
        /**
         * 最简单的是层序遍历:
         */
        Queue<TreeNode>q=new ArrayDeque<>();
        int res=root.val;
        q.add(root);
        while (!q.isEmpty()){
            List<Integer>list=new ArrayList<>();
            int size=q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=q.remove();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
                list.add(cur.val);
            }
            res=list.get(0);
        }
        return res;
    }
    /**
     * 递归:
     * 如果使用递归法，如何判断是最后一行呢，其实就是深度最大的叶子节点一定是最后一行.
     * 所以要找深度最大的叶子节点。
     *
     * 那么如果找最左边的呢？
     * 可以使用前序遍历（当然中序，后序都可以，因为本题没有 中间节点的处理逻辑，只要左优先就行），保证优先左边搜索，然后记录深度最大的叶子节点，此时就是树的最后一行最左边的值。
     */
    public void findBottomLeftValue1(TreeNode root,int deep){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(deep>Deep){
                value=root.val;
                //叶子结点更新最大深度
                Deep=deep;
            }
        }
        if(root.left!=null){
            findBottomLeftValue1(root.left,deep+1);
        }
        if(root.right!=null){
            findBottomLeftValue1(root.right,deep+1);
        }
    }
}
