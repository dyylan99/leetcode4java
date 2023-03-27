package offer;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/22 14:42
 * @description 剑指 Offer 37. 序列化二叉树
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * 空节点标记为:"n",节点间分割为";"
         */
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            //使用poll可以允许有空值
            TreeNode remove = queue.poll();
            if(remove!=null){
                 sb.append(remove.val);
                 queue.add(remove.left);
                 queue.add(remove.right);
            }else{
                sb.append("n");
            }
            sb.append(";");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //字符串的格式为:  1;2;-3;n;n;4;5;n;n;n;n;
        String[] split = data.split(";");
        List<TreeNode>list=new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(!split[i].equals("n")){
                //树节点列表
                list.add(new TreeNode(Integer.parseInt(split[i])));
            }else{
                list.add(null);
            }
        }
        if(list.isEmpty()){
            return null;
        }
        int index=0;
        int build=0;
        while (index<list.size()){
            if(++index<list.size()){
                list.get(build).left=list.get(index);
            }
            if(++index<list.size()){
                list.get(build).right=list.get(index);
            }
            //跳过null
            while (++build<list.size()&&list.get(build)==null){

            }
        }
        return list.get(0);

    }
}
