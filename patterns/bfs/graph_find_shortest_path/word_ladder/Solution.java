package patterns.bfs.graph_find_shortest_path.word_ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

class DFSBacktrackRememberLetterDiff implements Solution {

    private boolean isOneLetterDiff(String a, String b) {
        // Assert a.length() == b.length()
        int diffCounter = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diffCounter++;
        }
        return diffCounter == 1;
    }

    private int dfs(String curWord, String endWord, List<String> wordList, Set<String> visited, Map<String, List<String>> next) {
        if (curWord.equals(endWord)) return 0;
        if (visited.size() == wordList.size()) return -1;

        int len = -1, buf = -1;
        if (next.containsKey(curWord)) {
            for (String w: next.get(curWord)) {
                if (!visited.contains(w)) {
                    visited.add(w);
                    buf = dfs(w, endWord, wordList, visited, next);
                    visited.remove(w);

                    if (buf != -1) {
                        len = (len == -1) ? buf+1 : Math.min(len, buf+1);
                    }
                }
            }
        }

        return len;
    }

    @Override
    @SuppressWarnings("serial")
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> next = new HashMap<>() {{
            for (int i=0; i<wordList.size(); i++) {
                for (int j=i+1; j<wordList.size(); j++) {
                    if (isOneLetterDiff(wordList.get(i), wordList.get(j))) {
                        this.computeIfAbsent(wordList.get(i), k -> new ArrayList<>()).add(wordList.get(j));
                        this.computeIfAbsent(wordList.get(j), k -> new ArrayList<>()).add(wordList.get(i));
                    }
                }
            }

            if (!this.containsKey(beginWord)) {
                for (int j=0; j<wordList.size(); j++) {
                    if (isOneLetterDiff(beginWord, wordList.get(j))) {
                        this.computeIfAbsent(beginWord, k -> new ArrayList<>()).add(wordList.get(j));
                    }
                }
            }
        }};

        int rst = dfs(beginWord, endWord, wordList, new HashSet<>(), next);
        return (rst != -1) ? rst+1 : 0;
    }

}

class BFSFindShortestPath implements Solution {

    private boolean isOneLetterDiff(String a, String b) {
        // Assert a.length() == b.length()
        int diffCounter = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diffCounter++;
        }
        return diffCounter == 1;
    }

    @SuppressWarnings("serial")
    private int bfs(String beginWord, String endWord, Map<String, Set<String>> next) {

        Queue<String> q = new LinkedList<>() {{ this.add(beginWord); }};
        int level = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            level++;
            while (levelSize-- > 0) {
                String curWord = q.poll();

                if (next.containsKey(curWord)) {

                    if (next.get(curWord).contains(endWord))
                        return level + 1;
                
                    for (String n: next.get(curWord)) {
                        q.add(n);
                    }
                    next.remove(curWord);
                }
            }
            
        }

        return 0;
    }

    @Override
    @SuppressWarnings("serial")
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> next = new HashMap<>() {{
            for (int i=0; i<wordList.size(); i++) {
                for (int j=i+1; j<wordList.size(); j++) {
                    if (isOneLetterDiff(wordList.get(i), wordList.get(j))) {
                        this.computeIfAbsent(wordList.get(i), k -> new HashSet<>()).add(wordList.get(j));
                        this.computeIfAbsent(wordList.get(j), k -> new HashSet<>()).add(wordList.get(i));
                    }
                }
            }

            if (!this.containsKey(beginWord)) {
                for (int j=0; j<wordList.size(); j++) {
                    if (isOneLetterDiff(beginWord, wordList.get(j))) {
                        this.computeIfAbsent(beginWord, k -> new HashSet<>()).add(wordList.get(j));
                    }
                }
            }
        }};

        return bfs(beginWord, endWord, next);
    }

}
