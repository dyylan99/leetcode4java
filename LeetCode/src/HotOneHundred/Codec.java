package HotOneHundred;

import Tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/10 14:01
 * @description 297. 二叉树的序列化与反序列化
 **/
public class Codec {
    // Encodes a tree to a single string.
    //序列化一个二叉树,采用层序遍历的方式将其序列化,一层过后加一个:
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            //当队列为空时,poll会返回空
            TreeNode poll = q.poll();
            if(poll!=null){
                //当前节点不为空就将其子节点添加到队列中
                q.add(poll.left);
                q.add(poll.right);
                sb.append(poll.val);
            } else{
                //当前节点为空就添加 n
               sb.append("n");
           }
           //分割每个节点
           sb.append(";");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //字符串的格式为:  1;2;-3;n;n;4;5;n;n;n;n;
        int len=data.length();
        List<TreeNode>list=new ArrayList<>();
        String[] nums = data.split(";");
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = null;
            if(!nums[i].equals("n")){
                node=new TreeNode(Integer.parseInt(nums[i]));
            }
            list.add(node);
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

    @Test
    public void test(){
        String s="1;-2";
        String[] split = s.split(";");
        for (String s1 : split) {
            System.out.println(Integer.parseInt(s1));
        }
        System.out.println(s.length());
    }
}
