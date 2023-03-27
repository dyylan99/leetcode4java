package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/20 13:46
 * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 **/
public class verifyPostorder_ {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur(int[] postorder, int lStart, int root){
        if(lStart>=root){
            return true;
        }
        int p=lStart;
        while (postorder[p]<postorder[root]){
            p++;
        }
        //右子树的开始位置
        int rightStart=p;

        while (postorder[p]>postorder[root]){
            p++;
        }
        //如果是正确序列的话,此时p的值为root
        return p==root&&recur(postorder,lStart,rightStart-1)&&recur(postorder,rightStart,root-1);
    }

}
