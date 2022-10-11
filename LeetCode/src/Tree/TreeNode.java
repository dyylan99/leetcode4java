package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:16
 * @description TODO
 **/
public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;

 TreeNode() {
 }

 TreeNode(int val) {
  this.val = val;
 }

 TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
 }
}
