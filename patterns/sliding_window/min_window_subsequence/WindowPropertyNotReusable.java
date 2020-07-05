package patterns.sliding_window.min_window_subsequence;

import java.util.*;

public class WindowPropertyNotReusable extends Solution {

    @Override
    public String minWindow(String S, String T) throws Exception {
        Map<Character, List<Integer>> m = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (!m.containsKey(c)) m.put(c, new ArrayList<Integer>());

            m.get(c).add(i);
        }

        if (!m.containsKey(T.charAt(0))) return "";

        String rst = "";
        for (int lastSIdx : m.get(T.charAt(0))) {
            int firstSIdx = lastSIdx;
            boolean skip = false;

            for (int i=1; i<T.length(); i++) {
                char target = T.charAt(i);
                if (!m.containsKey(target)) {
                    skip = true;
                    break;
                }
    
                boolean updated = false;
                for (int next : m.get(target)) {
                    if (next > lastSIdx) {
                        lastSIdx = next;
                        updated = true;
                        break;
                    }
                }
    
                if (!updated) {
                    skip = true;
                    break;
                }
            }

            if (skip) continue;
            else {
                if (rst == "" || rst.length() > lastSIdx - firstSIdx + 1)
                    rst = S.substring(firstSIdx, lastSIdx+1);
            }
        }

        return rst;
    }
    
}