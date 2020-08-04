package patterns.backtrack.word_ladder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Solution {
    int ladderLength(String beginWord, String endWord, List<String> wordList);    
}

class DFSBacktrack implements Solution {

    private boolean isOneLetterDiff(String a, String b) {
        // Assert a.length() == b.length()
        int diffCounter = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diffCounter++;
        }
        return diffCounter == 1;
    }

    private int dfs(String curWord, String endWord, List<String> wordList, Set<String> visited) {
        if (curWord.equals(endWord)) return 0;
        if (visited.size() == wordList.size()) return -1;

        int len = -1, buf = -1;
        for (String w: wordList) {
            if (!visited.contains(w) && isOneLetterDiff(curWord, w)) {
                visited.add(w);
                buf = dfs(w, endWord, wordList, visited);
                visited.remove(w);

                if (buf != -1) {
                    len = (len == -1) ? buf+1 : Math.min(len, buf+1);
                }
            }
        }

        return len;
    }

    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int rst = dfs(beginWord, endWord, wordList, new HashSet<>());
        return (rst != -1) ? rst+1 : 0;
    }

}
