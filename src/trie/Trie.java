package trie;

import java.util.*;

public class Trie {
    // Problem 208
    class TreeNode {
        boolean isWord;
        Map<Character, TreeNode> map;
        public TreeNode(){
            isWord = false;
            map = new HashMap<>();
        }
    }
    
    TreeNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!cur.map.containsKey(ch))
                cur.map.put(ch, new TreeNode());
            cur = cur.map.get(ch);
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!cur.map.containsKey(ch)) return false;
            cur = cur.map.get(ch);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!cur.map.containsKey(ch)) return false;
            cur = cur.map.get(ch);
        }
        return true;
    }
}
