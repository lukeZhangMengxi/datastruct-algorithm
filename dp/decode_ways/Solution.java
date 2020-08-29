package dp.decode_ways;

import java.util.HashSet;
import java.util.Set;

abstract class Solution {

    abstract int numDecodings(String s);

    char convert(String s, int i, int j) {
        if (i < j && s.charAt(i) == '0') return '#';

        int tmp = Integer.parseInt(s.substring(i, j+1));
        if (tmp > 0 && tmp <= 26) return (char) (tmp - 1 + 'A');
        else return '#';
    }
}

class Tabulation extends Solution {

    @Override
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int last=0, oneBeforeLast=0, cur=0;
        char oneDigit = convert(s, 0, 0);
        char twoDigit;
        if (oneDigit == '#') return 0;
        last = 1;

        for (int i=1; i<s.length(); i++) {
            oneDigit = convert(s, i, i);
            if (oneDigit != '#') cur += last;

            twoDigit = convert(s, i-1, i);
            if (twoDigit != '#') cur += (i-2 >= 0) ? oneBeforeLast : 1;

            // Rotate
            oneBeforeLast = last;
            last = cur;
            cur = 0;
        }

        return last;
    }

}

class Memoization extends Solution {

    int dfs(String s, int i, Integer[] dp) {
        if (i == s.length()) { return 1; }
        if (s.charAt(i) == '0') return 0;

        if (i+1 == s.length()) return dfs(s, i+1, dp);

        if (dp[i] != null) return dp[i];

        char oneDigit = convert(s, i, i);
        char twoDigit = convert(s, i, i+1);
        if (oneDigit != '#' && twoDigit != '#') {
            dp[i] = dfs(s, i+1, dp) + dfs(s, i+2, dp);
            return dp[i];
        } else if (oneDigit != '#') {
            dp[i] = dfs(s, i+1, dp);
            return dp[i];
        } else if (twoDigit != '#') {
            dp[i] = dfs(s, i+2, dp);
            return dp[i];
        } else {
            return 0;
        }
    }

    @Override
    public int numDecodings(String s) {
        return dfs(s, 0, new Integer[s.length()]);
    }

}

class BBF extends Solution {

    int dfs(String s, int i) {
        if (i == s.length()) { return 1; }
        if (s.charAt(i) == '0') return 0;

        if (i+1 == s.length()) return dfs(s, i+1);

        char oneDigit = convert(s, i, i);
        char twoDigit = convert(s, i, i+1);
        if (oneDigit != '#' && twoDigit != '#') {
            return dfs(s, i+1) + dfs(s, i+2);
        } else if (oneDigit != '#') {
            return dfs(s, i+1);
        } else if (twoDigit != '#') {
            return dfs(s, i+2);
        } else {
            return 0;
        }
    }

    @Override
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

}

class BF extends Solution {

    void dfs(String s, int i, Set<String> rst, StringBuilder buf) {
        if (i == s.length()) { rst.add(buf.toString()); return; }
        if (s.charAt(i) == '0') return;

        char oneDigit = convert(s, i, i);
        if (oneDigit != '#') {
            buf.append(oneDigit);
            dfs(s, i+1, rst, buf);
            buf.deleteCharAt(buf.length()-1);
        }

        if (i+1 < s.length()) {
            char twoDigit = convert(s, i, i+1);
            if (twoDigit != '#') {
                buf.append(twoDigit);
                dfs(s, i+2, rst, buf);
                buf.deleteCharAt(buf.length()-1);
            }
        }
    }

    @Override
    public int numDecodings(String s) {
        Set<String> rst = new HashSet<>();
        
        dfs(s, 0, rst, new StringBuilder());

        return rst.size();
    }

}
