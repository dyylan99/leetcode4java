package Greed;


import com.sun.source.tree.Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/12 13:37
 * @description 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 968. 监控二叉树
 **/
public class minCameraCover_ {

    int res = 0;

    // 1代表放置摄像头  2代表未放置摄像头但被摄像头覆盖了  0代表没有被摄像头覆盖
    public int minCameraCover(TreeNode root) {
        if (minCam(root) == 0) {
            res++;
        }
        return res;
    }

    public int minCam(TreeNode root) {
        if (root == null) {
            //空节点默认有覆盖,避免在叶子节点上放置摄像头
            return 2;
        }
        int left = minCam(root.left);
        int right = minCam(root.right);

        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }
}
