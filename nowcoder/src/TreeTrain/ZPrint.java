package TreeTrain;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/9 9:42
 * @description 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * 要求：空间复杂度：O(n)，时间复杂度：O(n)
 **/
public class ZPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /**
         * 思路:借助一个辅助常量,判断是否需要反转
         * 同时借助队列
         */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        boolean revers=false;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(pRoot);
        while (!q.isEmpty()) {
            int l=q.size();
            ArrayList<Integer> list = new ArrayList<>();
           {
                for (int i = 0; i < l; i++) {
                    TreeNode node = q.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            if(revers){
                Collections.reverse(list);
            }
            res.add(list);
            revers=!revers;
        }
        return res;
    }
    /**
     * 解法二:借助双栈,第一层由栈一从左向右推向栈二
     * 第二层由栈二从右向左推向栈一
     */
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot){
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        boolean reverse=false;
        ArrayList<Integer>work=new ArrayList<>();
        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        stack1.push(pRoot);
        /**
         * 将需要从右往左遍历的节点放入stack2,并且按照栈的顺序遍历节点(stack默认的读取顺序就可以实现从左往右)
         */
        while(!stack1.empty()||!stack2.empty()) {
            while (!stack1.isEmpty()) {
                TreeNode cur = stack1.pop();
                work.add(cur.val);
                if (cur.left != null) {
                    stack2.push(cur.left);
                }
                if (cur.right != null) {
                    stack2.push(cur.right);
                }
            }
            res.add(work);
            work = new ArrayList<>();
            /**
             * 将需要从左往右遍历的节点放入stack1,并按照默认的栈顺序从右往左遍历节点
             */
            while (!stack2.isEmpty()) {
                TreeNode cur = stack2.pop();
                work.add(cur.val);
                if (cur.right != null) {
                    stack2.push(cur.right);
                }
                if (cur.left != null) {
                    stack2.push(cur.left);
                }
            }
            if (work.size() != 0) {
                res.add(work);
                work = new ArrayList<>();
            }
        }
        return res;
    }
}
