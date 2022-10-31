package Tree;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/14 12:40
 * @description 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 112:路径总和
 **/
public class hasPathSum_ {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /**
         * 迭代:效率较低
         *
         */
        if (root == null) {
            return false;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        s2.push(root.val);
        while (!s1.empty()) {
            int size = s1.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = s1.pop();
                int sum = s2.pop();
                if (cur.right == null && cur.left == null) {
                    if (sum == targetSum) {
                        return true;
                    }
                }
                if (cur.right != null) {
                    s1.push(cur.right);
                    s2.push(cur.right.val + sum);
                }
                if (cur.left != null) {
                    s1.push(cur.left);
                    s2.push(cur.left.val + sum);
                }
            }
        }
        return false;
    }

    boolean traversal(TreeNode root, int count) {
        /**
         * 让计数器count初始为目标和,然后每次去减路径上节点的值
         * 若最后count为0,则说明找到了目标路径,若遍历到了叶子节点,那就是没找到
         */
        //停止条件
        if (root.left == null && root.right == null) {
            //找到了叶子节点若计数器为0则返回true,若计数器不为0,说明不符合要求,返回false
            return count == 0;
        }
        //if(root.right==null&&root.left==null){
        //    //找到叶子结点但是count不为0
        //    return false;
        //}
        //若左节点不为零
        if (root.left != null) {
            //若左节点的逻辑为真
            if (traversal(root.left, count - root.left.val)) {
                return true;
            }
        }
        if (root.right != null) {
            //若右节点的逻辑为真
            if (traversal(root.right, count - root.right.val)) {
                return true;
            }
        }
        return false;
    }

    boolean traversal1(TreeNode root, int count) {
        /**
         * 让计数器count初始为目标和,然后每次去减路径上节点的值
         * 若最后count为0,则说明找到了目标路径,若遍历到了叶子节点,那就是没找到
         * 这个版本体现回溯过程
         */
        //停止条件
        if (root.left == null && root.right == null) {
            //找到了叶子节点若计数器为0则返回true,若计数器不为0,说明不符合要求,返回false
            return count == 0;
        }
        //if(root.right==null&&root.left==null){
        //    //找到叶子结点但是count不为0
        //    return false;
        //}
        //若左节点不为零
        if (root.left != null) {
            //若左节点的逻辑为真
            count -= root.left.val;
            if (traversal(root.left, count)) {
                return true;
            }
            //回溯
            count += root.left.val;
        }
        if (root.right != null) {
            //若右节点的逻辑为真
            count -= root.right.val;
            if (traversal(root.right, count)) {
                return true;
            }

            //回溯
            count += root.right.val;
        }
        return false;
    }
}
