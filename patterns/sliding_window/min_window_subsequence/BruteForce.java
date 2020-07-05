package patterns.sliding_window.min_window_subsequence;

public class BruteForce extends Solution {

    @Override
    public String minWindow(String S, String T) throws Exception {
        isValid(S, T);

        String rst = "";
        for (int i=0; i<S.length(); i++) {
            for (int j=i; j<S.length(); j++) {
                if (isSubsequence(S, T, i, j) && (rst.length() == 0 || rst.length() > j-i+1))
                    rst = S.substring(i, j+1);
            }
        }

        return rst;
    }

    private boolean isSubsequence(String S, String T, int i, int j) {
        if (j-i+1 < T.length()) return false;

        for (int idx=0; idx<T.length(); idx++) {
            // Try finding the next correct index between i an j
            while (i <= j && S.charAt(i) != T.charAt(idx))
                i++;

            // return false if fail finding the index
            if (i > j) return false;

            // current i is used
            i++;
        }
        return true;
    }
    
}