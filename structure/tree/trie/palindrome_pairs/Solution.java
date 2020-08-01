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

@SuppressWarnings("serial")
class MapFindMatch implements Solution {

    private boolean isPalindrome(String s, int l, int r) {
        // TO-DO: Validation
        while (l<r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }


    private List<String> targetsWhenSourceOnRight(String src) {
        
        return new ArrayList<>() {{
            StringBuilder buf = new StringBuilder();
            for (int i=src.length()-1; i>=0; i--) {
                buf.append(src.charAt(i));

                if (isPalindrome(src, 0, i-1)) this.add(buf.toString());
            }

            if (isPalindrome(src, 0, src.length()-1)) this.add("");
        }};
    }

    private List<String> targetsWhenSourceOnLeft(String src) {
        
        return new ArrayList<>() {{
            StringBuilder buf = new StringBuilder();
            for (int i=0; i<src.length(); i++) {
                buf.append(src.charAt(i));

                if (isPalindrome(src, i+1, src.length()-1)) {
                    this.add(buf.reverse().toString());
                    buf.reverse(); // reverse back
                }
            }

            if (isPalindrome(src, 0, src.length()-1)) this.add("");
        }};
    }

    @Override
    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> wordToIndex = new HashMap<>() {{
            for (int i=0; i<words.length; i++) this.put(words[i], i);
        }};

        return new ArrayList<>() {{
            for (int i=0; i<words.length; i++) {
                String cur = words[i];

                // Case 1: same length
                String target = new StringBuilder(cur).reverse().toString();
                if (wordToIndex.containsKey(target) && wordToIndex.get(target) != i) {
                    this.add(Arrays.asList(i, wordToIndex.get(target)));
                }

                // Case 2: current string is longer and it is on the left
                for (String t: targetsWhenSourceOnLeft(cur)) {
                    if (t.length() != cur.length() && wordToIndex.containsKey(t) && wordToIndex.get(t) != i)
                        this.add(Arrays.asList(i, wordToIndex.get(t)));
                }

                // Case 3: current string is longer and it is on the right
                for (String t: targetsWhenSourceOnRight(cur)) {
                    if (t.length() != cur.length() && wordToIndex.containsKey(t) && wordToIndex.get(t) != i)
                        this.add(Arrays.asList(wordToIndex.get(t), i));
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
