package patterns.sliding_window.max_len_k_distinct_char;

import java.util.HashMap;
import java.util.Map;

public class ReuseSubstrCount extends Solution {

    @Override
    public int findLength(String str, int k) throws Exception {
        isValid(str, k);

        int startIdx=0, endIdx=0, rst=0;
        Map<Character, Integer> count = new HashMap<>();
        while (endIdx < str.length()) {
            // Add endIdx c into count until not valid
            while (count.size() <= k && endIdx < str.length()) {
                Character c = str.charAt(endIdx);
                if (count.containsKey(c))
                    count.put(c, count.get(c) + 1);
                else {
                    count.put(c, 1);
                    if (count.size() > k) break;
                }
                endIdx++;
            }

            // So far, subStr(startIdx, endIdx-1) is valid
            rst = Math.max(rst, endIdx-startIdx);

            // Remove startIdx from count until valid
            while (count.size() > k && startIdx < endIdx) {
                Character c = str.charAt(startIdx++);
                if (count.getOrDefault(c, 0) <= 1) {
                    count.remove(c);
                } else {
                    count.put(c, count.get(c) - 1);
                }   
            }

            // Update endIdx for a new value that is not put into count yet
            endIdx++;

        }

        return rst;
    }
    
}