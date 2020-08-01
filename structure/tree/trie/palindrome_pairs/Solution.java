package structure.tree.trie.palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Solution {
    List<List<Integer>> palindromePairs(String[] words);    
}

class BruteForce implements Solution {

    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;  // arguable

        int l=0, r=s.length()-1;
        while (l<r) if (s.charAt(l++) != s.charAt(r--)) return false;

        return true;
    }

    @Override
    @SuppressWarnings("serial")
    public List<List<Integer>> palindromePairs(String[] words) {
        
        return new ArrayList<>() {{
            for (int i=0; i<words.length; i++) {
                for (int j=0; j<words.length; j++) {
                    if (i != j && isPalindrome(words[i] + words[j]))
                        this.add(Arrays.asList(i, j));
                }
            }
        }};
    }

}

class UseTrie implements Solution {

    class TrieNode {
        String word;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[60];
        }
    }

    private void addStringToTrie(String s, TrieNode root) {
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            if (cur.children[s.charAt(i) - 'A'] == null)
                cur.children[s.charAt(i) - 'A'] = new TrieNode();
            cur = cur.children[s.charAt(i) - 'A'];
        }
        cur.word = s;
    }

    private String getPalindrome(String s, TrieNode root) {
        TrieNode cur = root;
        for (int i=s.length()-1; i>=0; i--) {
            if (cur.children[s.charAt(i) - 'A'] != null) {
                cur = cur.children[s.charAt(i) - 'A'];
            } else {
                String rest = s.substring(0, i+1);
                int l=0, r=rest.length()-1;
                boolean restIsPalindrome = true;
                while (l<r) {
                    if (rest.charAt(l++) != rest.charAt(r--)) {
                        restIsPalindrome = false; break;
                    }
                }
                return restIsPalindrome ? cur.word : null;
            }
        }
        return cur.word;
    }

    @Override
    @SuppressWarnings("serial")
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode() {{
            for (String w: words) addStringToTrie(w, this);
        }};

        Map<String, Integer> wordToIndex = new HashMap<>() {{
            for (int i=0; i<words.length; i++) this.put(words[i], i);
        }};

        return new ArrayList<>() {{
            for (int i=0; i<words.length; i++) {
                if (words[i] == "") {
                    for (TrieNode tn: root.children) {
                        if (tn != null && tn.word != null) {
                            this.add(Arrays.asList(wordToIndex.get(tn.word), i));
                            this.add(Arrays.asList(i, wordToIndex.get(tn.word)));
                        }
                    }
                } else {
                    String target = getPalindrome(words[i], root);
                    if (target != null && wordToIndex.get(target) != i)
                        this.add(Arrays.asList(wordToIndex.get(target), i));
                }
            }
        }};
    }

}
