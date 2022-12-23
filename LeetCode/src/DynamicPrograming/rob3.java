package DynamicPrograming;



/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/23 14:08
 * @description 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 *
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * 337. 打家劫舍 III
 **/
public class rob3 {
    public int rob(TreeNode root) {
        /**
         * 我的第一思路还是: 想办法把二叉树转化为数组,
         * 但是不是:
         *
         */
        int[] res=robTree(root);
        return Math.max(res[0],res[1]);
    }

    public int[] robTree(TreeNode cur){
        if(cur==null){
            return new int[]{0,0};
        }
        //下标0 不偷
        //下标1 偷
        int[] left = robTree(cur.left);
        int[] right=robTree(cur.right);
        //偷cur, 左右子树都不能偷
        int val1=cur.val+left[0]+right[0];
        //不偷
        int val2=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{val2,val1};
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}
