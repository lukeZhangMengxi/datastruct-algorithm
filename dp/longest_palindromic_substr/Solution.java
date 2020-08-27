package dp.longest_palindromic_substr;

abstract class Solution {
    abstract String longestPalindrome(String s);    

    boolean isPalindomic(String s, int i, int j) {
        while (i<j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

class SpaceReducedTabulation extends Solution {

    @Override
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[2][s.length()];
        for (int i=0; i<dp.length; i++) { dp[1][i] = true; }
        for (int i=0; i<dp.length-1; i++) { dp[0][i] = isPalindomic(s, i, i+1); }

        int len = 1, start = 0, end = 0;
        for (int next_idx=1; next_idx<s.length(); next_idx++) {
            for (int i=0; i<s.length()-next_idx; i++) {
                int j = i+next_idx;
                if (i+2 <= j && dp[(next_idx+1)%2][i+1] != null) {
                    if (dp[(next_idx+1)%2][i+1] && s.charAt(i) == s.charAt(j)) {
                        dp[(next_idx+1)%2][i] = true;
                    } else {
                        dp[(next_idx+1)%2][i] = false;
                    }
                } else {
                    dp[(next_idx+1)%2][i] = isPalindomic(s, i, j);
                }

                if (dp[(next_idx+1)%2][i] && j-i+1 > len) {
                    start = i;
                    end = j;
                    len = j-i+1;
                }

            }
        }
        return s.substring(start, end+1);
    }

}

class Tabulation extends Solution {

    @Override
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) { dp[i][i] = true; }

        int len = 1, start = 0, end = 0;
        for (int next_idx=1; next_idx<s.length(); next_idx++) {
            for (int i=0; i<s.length()-next_idx; i++) {
                int j = i+next_idx;
                if (i+2 <= j && dp[i+1][j-1] != null) {
                    if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = isPalindomic(s, i, j);
                }

                if (dp[i][j] && j-i+1 > len) {
                    start = i;
                    end = j;
                    len = j-i+1;
                }

            }
        }
        return s.substring(start, end+1);
    }

}

class BruteForce extends Solution {

    @Override
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        int len = 1, start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                if (isPalindomic(s, i, j) && j-i+1 > len) {
                    start = i;
                    end = j;
                    len = j-i+1;
                }
            }
        }
        return s.substring(start, end+1);
    }

}