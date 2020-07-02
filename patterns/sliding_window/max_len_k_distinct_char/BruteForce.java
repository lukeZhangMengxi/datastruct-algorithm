package patterns.sliding_window.max_len_k_distinct_char;

import java.util.HashSet;
import java.util.Set;

public class BruteForce extends Solution {

    @Override
    public int findLength(String str, int k) throws Exception {
        isValid(str, k);
        
        int rst = 0;
        for (int startIdx=0; startIdx<str.length(); startIdx++) {
            for (int endIdx=startIdx; endIdx<str.length(); endIdx++) {
                Set<Character> count = new HashSet<>();
                for (int i=startIdx; i<=endIdx; i++) {
                    count.add(str.charAt(i));
                }
                if (count.size() <= k)
                    rst = Math.max(rst, endIdx - startIdx + 1);
            }
        }

        return rst;
    }
    
}