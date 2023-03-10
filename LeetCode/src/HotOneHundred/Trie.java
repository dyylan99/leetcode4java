package HotOneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/9 11:12
 * @description TODO
 **/
public class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }

    public void insert(String word) {
        if (word==null||word.length()==0){
            return;
        }
        TrieNode tem=root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode subNode = tem.getSubNode(c);
            //如果子节点为空,就添加到前缀树中
            if(subNode==null){
                subNode=new TrieNode();
                tem.addSubNode(c,subNode);
            }
            tem=subNode;
            //如果到头了,那就设置结束标识
            if(i==word.length()-1){
                tem.setKeyword(true);
            }
        }
    }

    public boolean search(String word) {
        if (word==null||word.length()==0){
            return false;
        }
        TrieNode tem=root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            tem=tem.getSubNode(c);
            if(tem==null){
                return false;
            }else if(tem.isKeyword&&i==word.length()-1){
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
       TrieNode tem=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
                tem= tem.getSubNode(c);
            if(tem==null){
                return false;
            }

        }
        return true;
    }

    class TrieNode{

        private boolean isKeyword=false;

        private Map<Character,TrieNode>subNode=new HashMap<>();

        public boolean isKeyword(){
            return isKeyword;
        }

        public void setKeyword(boolean keyword) {
            isKeyword = keyword;
        }

        public void addSubNode(Character c,TrieNode node){
            subNode.put(c,node);
        }

        public TrieNode getSubNode(Character c){
            return subNode.get(c);
        }
    }
}
