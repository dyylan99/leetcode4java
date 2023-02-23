package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/23 10:33
 * @description
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *129. 求根节点到叶节点数字之和
 **/
public class sumNumbers_ {
    int res=0;
    List<Integer>path=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        path.add(root.val);
        recur(root);
        return res;
    }

    public void recur(TreeNode node){
        if(node.left==null&&node.right==null){
            res+=listToInt(path);
            return;
        }
        if(node.left!=null){
            path.add(node.left.val);
            recur(node.left);
            path.remove(path.size()-1);
        }
        if(node.right!=null){
            path.add(node.right.val);
            recur(node.right);
            path.remove(path.size()-1);
        }
        return;
    }

    public int listToInt(List<Integer>list){
        int sum=0;
        for (Integer integer : list) {
            sum=sum*10+integer;
        }
        return sum;
    }
}
