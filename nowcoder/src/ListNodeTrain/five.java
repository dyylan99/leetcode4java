package ListNodeTrain;

import java.util.ArrayList;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/27 11:49
 * @description 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * //最朴素的思路:
 * 在数组链表里取值:前面的合并的链表和后一个合并:
 **/

class ListNode5{
    int val;
    ListNode5 next;
    ListNode5(int val){
        this.val = val;
    }
}

/**
 * 解法一:两两合并,再和后一个合并,但是此解法需要先遍历数组中每个链表的所有值,再遍历数组中的所有链表,开销很大
 * 因为到后面若数据量大的话,前面合并的链表就过于长,每次都要遍历其中的所有元素
 * 因此有思路为:分治
 * 现将数组链表分为两部分,分别进行合并,最后再将这两部分合并为一个链表
 */
public class five {
    public ListNode5 mergeKLists(ArrayList<ListNode5> lists){
        ListNode5 res=null;
      for(int i=0;i<lists.size();i++){
          res=merge(lists.get(i),res);
      }
      return res;
    }

    /**
     *
     * 采用分治:但是这题分为两段时间复杂度还是过大
     * 若以后数据量大,还可以分为三段四段等
     */
    public ListNode5 mergeKLists1(ArrayList<ListNode5> lists){
        ListNode5 res1=null;
        ListNode5 res2=null;
        ListNode5 res=null;
        int k=lists.size()/2;
        for (int i = 0; i <k; i++) {
            res1=merge(lists.get(i),res1);
        }
        for (int i = k; i <lists.size(); i++) {
            res2=merge(lists.get(i),res2);
        }
        return merge(res1,res2);
    }

    /**
     *既然分两段解决不了,那就分到不能分为止:递归分治,两两划分,最后合并
     */
    public ListNode5 mergeKLists2(ArrayList<ListNode5> lists){
        if(lists==null||lists.size()==0){
            return  null;
        }
        return cutIntoTwo(lists,0,lists.size()-1);
    }
    public ListNode5 cutIntoTwo(ArrayList<ListNode5> lists,int left,int right){
        if(left==right){
            return lists.get(left);
        }

        int mid=left+((right-left)>>1);
        //return merge(cutIntoTwo(lists,left,mid),cutIntoTwo(lists,mid+1,right));
        ListNode5 leftList=cutIntoTwo(lists,left,mid);
        ListNode5 rightList=cutIntoTwo(lists,mid+1,right);
        return merge(leftList,rightList);
    }
    public ListNode5 merge(ListNode5 node1,ListNode5 node2){
        ListNode5 res=new ListNode5(0);
        ListNode5 workNode=res;
        while (node1!=null&&node2!=null){
            if(node1.val<=node2.val){
                workNode.next=node1;
                node1=node1.next;
            }else{
                workNode.next=node2;
                node2=node2.next;
            }
            workNode=workNode.next;
        }
        if(node1!=null){
            workNode.next=node1;
        }
        if(node2!=null){
            workNode.next=node2;
        }
        return res.next;
    }
}
