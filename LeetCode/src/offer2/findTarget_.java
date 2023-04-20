package offer2;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 14:08
 * @description TODO
 **/
public class findTarget_ {

    //使用set或者hashmap解决,但是没有用到二叉搜索树的性质
    Set<Integer>set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root==null)return false;

        if (set.contains(k-root.val))return true;

        set.add(root.val);

        return findTarget(root.left,k)||findTarget(root.right,k);
    }

}
