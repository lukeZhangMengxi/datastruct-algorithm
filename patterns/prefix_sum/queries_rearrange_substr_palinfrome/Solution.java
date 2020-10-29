package patterns.prefix_sum.queries_rearrange_substr_palinfrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Solution {

    public int[][] generatePrefixSum(String s) {
        int[][] prefixSum = new int[s.length()][26];
        for (int i=0; i<s.length(); i++) {
            if (i >0) {
                System.arraycopy(prefixSum[i-1], 0, prefixSum[i], 0, 26);
            }

            prefixSum[i][s.charAt(i) - 'a']++;
        }

        return prefixSum;
    }

    public boolean canMakePalindrome(String s, int i, int j, int k, int[][] prefixSum, Map<String, Integer> cache) {
        
        if (cache != null && cache.containsKey(i + "#" + j)) return (cache.get(i + "#" + j) / 2 <= k);

        int oddCount = 0;
        for (int x=0; x<26; x++) {
            if ( 
                ( i>0 ? (prefixSum[j][x] - prefixSum[i-1][x]) : prefixSum[j][x] ) 
                % 2 == 1 
            ) {
                oddCount++;
            }
        }
        if (cache != null) cache.put(i + "#" + j, oddCount);
        return oddCount / 2 <= k;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        Map<String, Integer> cache = new HashMap<>();
        int[][] prefixSum = generatePrefixSum(s);

        return new ArrayList<>() {
            {
                for (int[] q : queries) {
                    this.add(canMakePalindrome(s, q[0], q[1], q[2], prefixSum, cache));
                }
            }
        };
    }
}
