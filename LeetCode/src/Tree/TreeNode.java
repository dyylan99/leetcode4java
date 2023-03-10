package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/10/11 15:16
 * @description 
 **/
public class TreeNode {
 public int val;
public TreeNode left;
 public TreeNode right;

 public TreeNode() {
 }

 public TreeNode(int val) {
   this.val = val;
 }

 public TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
 }
}
