package Tree;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/23 16:00
 * @description TODO
 **/
public class binarySearchTree {
    public binarySearchTree left;
    public binarySearchTree right;
    public int val;

    public binarySearchTree(int val)
    {
        this.val = val;
    }
    public  static binarySearchTree insert(binarySearchTree root,int data){
        if (root==null){
            root=new binarySearchTree(data);
            return root;
        }
        binarySearchTree temp=root;
        while (true){
            if (data<temp.val){
                if (temp.left==null){
                    temp.left=new binarySearchTree(data);
                    return root;
                }
                temp=temp.left;
            }else{
                if (temp.right==null){
                    temp.right=new binarySearchTree(data);
                    return root;
                }
                temp=temp.right;
            }
        }
    }

    public static void main(String[] args) {
        binarySearchTree root=null;
        root=insert(root,1);
        root=insert(root,2);
        root=insert(root,6);
        root=insert(root,9);
        root=insert(root,7);
        midOrder(root);
    }
    public static void midOrder(binarySearchTree root){
        if (root==null){
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }
}
