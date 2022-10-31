package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/24 14:06
 * @description 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *501. 二叉搜索树中的众数
 **/
public class findMode_ {
    /**
     * 借助全局变量记录最大出现频率,当前元素出现频率,以及结果
     * @param root
     * @return
     */
    private int maxCount=0;
    private int count=0;
    private TreeNode pre=null;
    private ArrayList<Integer> res;
    public int[] findMode(TreeNode root) {
        if(root.left==null&&root.right==null){
            return new int[]{root.val};
        }
        res=new ArrayList<>();
        intraversal(root);
        int[] result =new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        return  result;
    }
    public void intraversal(TreeNode root){
        /**
         * 中序遍历二叉搜索树:
         */
        if(root==null){
            return ;
        }
        intraversal(root.left);
       if(pre==null||pre.val!=root.val){
           count=1;
       }else{
           count++;
       }
        if(count==maxCount){
            res.add(root.val);
        }
        if(count>maxCount){
            maxCount=count;
            res.clear();
            res.add(root.val);
        }
        pre=root;
        intraversal(root.right);
    }
    /**
     * 迭代法
     */
    public int[] findMode1(TreeNode root){
         int maxCount=0;
         int count=0;
         TreeNode pre=null;
         List<Integer> res=new ArrayList<>();
         Stack<TreeNode>s=new Stack<>();
         TreeNode cur=root;
         while (!s.empty()||cur!=null){
             //找到最左边的节点, 便于进行中序遍历
            if(cur!=null){
                s.push(cur);
                cur=cur.left;
            }else{
                cur=s.pop();
                //计数
                if(pre==null||cur.val!=pre.val){
                    count=1;
                }else{
                    count++;
                }
                //更新结果

                if(count>maxCount){
                    maxCount=count;
                    res.clear();
                    res.add(cur.val);
                }else if(count==maxCount){
                    res.add(cur.val);
                }

                pre=cur;
                cur=cur.right;
            }
         }
       return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
