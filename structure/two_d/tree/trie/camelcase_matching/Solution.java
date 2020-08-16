package structure.two_d.tree.trie.camelcase_matching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Solution {
    List<Boolean> camelMatch(String[] queries, String pattern);    
}

class BruteForce implements Solution {

    private boolean check(String q, String pattern) {
        int i=0, j=0;
        while (i < q.length()) {
            if (j < pattern.length() && q.charAt(i) == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(q.charAt(i))) {
                return false;
            }
            i++;
        }

        return j==pattern.length();
    }

    @Override
    @SuppressWarnings("serial")
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        return new ArrayList<Boolean>() {{
            for (String q: queries) {
                this.add(check(q, pattern));
            }
        }};
    }

}

class UseTrie implements Solution {

    class TrieNode {
        TrieNode child;
        char value;
    
        TrieNode(char v) {
            this.child = null;
            this.value = v;
        }
    }

    private void addPatternToTrie(String pattern, TrieNode root) {
        TrieNode curNode = root;
        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            if (curNode.child == null) curNode.child = new TrieNode(curChar);

            curNode = curNode.child;
        }
    }

    private void markIdIfMatch(String s, int sId, TrieNode root, Set<Integer> marked) {
        TrieNode curNode = root.child;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curNode != null) {
                char patternChar = curNode.value;
                if (curChar == patternChar) {
                    curNode = curNode.child;
                } else {
                    if (Character.isUpperCase(patternChar) && Character.isUpperCase(curChar)) return;
                    if (Character.isLowerCase(patternChar) && Character.isUpperCase(curChar)) return;
                }
            } else {
                if (Character.isUpperCase(curChar)) return;
            }
            
        }
        if (curNode == null)
            marked.add(sId);
    }

    @Override
    @SuppressWarnings("serial")
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        TrieNode root = new TrieNode('#') {{
            addPatternToTrie(pattern, this);
        }};

        Set<Integer> marked = new HashSet<>() {{
            for (int i=0; i<queries.length; i++) {
                markIdIfMatch(queries[i], i, root, this);
            }
        }};
        
        return new ArrayList<>() {{
            for (int i=0; i<queries.length; i++) {
                if (marked.contains(i)) this.add(true);
                else this.add(false);
            }
        }};
    }

}
