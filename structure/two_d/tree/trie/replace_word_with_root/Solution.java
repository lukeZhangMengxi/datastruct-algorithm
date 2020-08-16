package structure.two_d.tree.trie.replace_word_with_root;

import java.util.Collections;
import java.util.List;

interface Solution {
    String replaceWords(List<String> dict, String sentence);    
}

class BruteForce implements Solution {

    private String replaceIfRooted(String in, List<String> sortedDict) {
        for (String root: sortedDict) {
            if (in.length() > root.length() && in.substring(0, root.length()).compareTo(root) == 0) {
                return root;
            }
        }
        return in;
    }

    @Override
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, (a, b) -> a.compareTo(b));

        String[] buf = sentence.split(" ");
        for (int i=0; i<buf.length; i++) {
            buf[i] = replaceIfRooted(buf[i], dict);
        }
        return String.join(" ", buf);
    }

}

class UseTrie implements Solution {

    class TrieNode {
        String word;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private void addStringToTrie(String s, TrieNode root) {
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }

    private String replaceIfRooted(String in, TrieNode root) {
        TrieNode cur = root;
        for (int i=0; i<in.length(); i++) {
            if (cur.children[in.charAt(i) - 'a'] != null) {
                cur = cur.children[in.charAt(i) - 'a'];
            } else {
                return in;
            }

            if (cur.word != null) return cur.word;
        }

        return in;
    }

    @Override
    public String replaceWords(List<String> dict, String sentence) {
        
        TrieNode root = new TrieNode() {{
            for (String d: dict) addStringToTrie(d, this);
        }};

        String[] buf = sentence.split(" ");
        for (int i=0; i<buf.length; i++) {
            buf[i] = replaceIfRooted(buf[i], root);
        }
        return String.join(" ", buf);
    }

}
