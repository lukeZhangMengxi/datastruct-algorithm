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
