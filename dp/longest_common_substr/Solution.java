package dp.longest_common_substr;

import java.util.Arrays;

interface Solution {

    public int getMaxCommonSubstrLen(String a, String b);
    
}

class Recursion implements Solution {

    private int helper(String a, int i, String b, int j, int count) {
        if (i == a.length() || j == b.length()) return count;

        int rst = count;

        if (a.charAt(i) == b.charAt(j)) rst = helper(a, i+1, b, j+1, count+1);

        rst = Math.max(rst, helper(a, i, b, j+1, 0));
        rst = Math.max(rst, helper(a, i+1, b, j, 0));

        return rst;
    }

    @Override
    public int getMaxCommonSubstrLen(String a, String b) {
        return helper(a, 0, b, 0, 0);
    }

}

class Memoization implements Solution {

    int[][] dp;

    private int helper(String a, int i, String b, int j, int count) {
        if (i == a.length() || j == b.length()) return count;
        if (dp[i][j] != -1) return dp[i][j];

        int rst = count;

        if (a.charAt(i) == b.charAt(j)) {
            rst = helper(a, i+1, b, j+1, count+1);
        }

        rst = Math.max(rst, helper(a, i+1, b, j, 0));
        rst = Math.max(rst, helper(a, i, b, j+1, 0));

        dp[i][j] = rst - count;
        return rst;
    }

    @Override
    public int getMaxCommonSubstrLen(String a, String b) {
        dp = new int[a.length()][b.length()];
        for (int[] r: dp) Arrays.fill(r, -1);

        int r = helper(a, 0, b, 0, 0);
        return r;
    }

}

class Tabulation implements Solution {

    private int[][] dp;

    @Override
    public int getMaxCommonSubstrLen(String a, String b) {
        dp = new int[a.length()+1][b.length()+1];

        int rst = 0;
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
                rst = Math.max(rst, dp[i][j]);
            }
        }

        return rst;
    }

}
