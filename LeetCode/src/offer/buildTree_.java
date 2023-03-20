package offer;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/15 11:46
 * @description 剑指 Offer 07. 重建二叉树
 **/
public class buildTree_ {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer,Integer>map=new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return traverseBuild(preorder,0,preorder.length,inorder,0,inorder.length,map);
        }

        //区间全部都为左闭右开区间
        private TreeNode traverseBuild(int[]preorder, int p_start, int p_end
                , int[] inorder, int i_start, int i_end, Map<Integer,Integer>map){

            if(p_start==p_end){
                return null;
            }
            int rootVal=preorder[p_start];
            //找出根节点在中序数组中的下标
            Integer i_root_index = map.get(rootVal);
            int leftNum=i_root_index-i_start;
            TreeNode root=new TreeNode(rootVal);
            root.left=traverseBuild(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index-1,map);
            root.right=traverseBuild(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end,map);
            return root;
        }
}
