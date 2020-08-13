package random_questions.search_auto_complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Solution {
    public void init(String[] sentences, int[] times);
    public List<String> input(char c);
}

@SuppressWarnings("serial")
class BruteForce implements Solution {

    Map<String, Integer> hotDegree;
    StringBuilder buf;

    @Override
    public void init(String[] sentences, int[] times) {
        hotDegree = new HashMap<>() {{
            for (int i=0; i<sentences.length; i++) {
                this.put(
                    sentences[i],
                    this.getOrDefault(sentences[i], 0) + times[i]
                );
            }
        }};

        buf = new StringBuilder();
    }

    @Override
    public List<String> input(char c) {
        if (c != '#') {
            buf.append(c);
            return autoComplete();
        } else {
            hotDegree.put(buf.toString(), hotDegree.getOrDefault(buf.toString(), 0) + 1);
            buf = new StringBuilder();
            return Arrays.asList();
        }
    }

    private List<String> autoComplete() {
        return new ArrayList<>() {{
            String cur = buf.toString();
            for (String t: hotDegree.keySet()) {
                if (t.length() >= cur.length() && t.substring(0, cur.length()).equals(cur))
                    this.add(t);
            }

            Collections.sort(this, 
                (a, b) -> hotDegree.get(a) != hotDegree.get(b) ?
                hotDegree.get(b) - hotDegree.get(a) : a.compareTo(b)
            );

            if (this.size() > 3) this.removeRange(3, this.size());
        }};
    }

}
