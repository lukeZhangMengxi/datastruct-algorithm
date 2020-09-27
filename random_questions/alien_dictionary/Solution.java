package random_questions.alien_dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

interface Solution {
    String alienOrder(String[] words);
}

@SuppressWarnings("serial")
class GraphNoIncomingEdgeNodes implements Solution {

    @Override
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjacentGraph = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String w: words) {
            for (char c: w.toCharArray()) {
                counts.put(c, 0);
                adjacentGraph.put(c, new ArrayList<>());
            }
        }

        for (int i=0; i<words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adjacentGraph.get(w1.charAt(j)).add(w2.charAt(j));
                    counts.put(w2.charAt(j), counts.get(w2.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder buf = new StringBuilder();
        Queue<Character> q = new LinkedList<>() {{
            for (Character c : counts.keySet()) {
                if (counts.get(c) == 0) this.add(c);
            }
        }};
        while (!q.isEmpty()) {
            Character c = q.remove();
            buf.append(c);

            for (Character next: adjacentGraph.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next) == 0) q.add(next);
            }
        }

        return (buf.length() > counts.size()) ? "" : buf.toString();
    }

}
