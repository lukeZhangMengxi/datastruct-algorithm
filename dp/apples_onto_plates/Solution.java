package dp.apples_onto_plates;

import java.util.Arrays;

interface Solution {
    
    public int count(int numApple, int numPlate);

}

class Recursion implements Solution {

    private int recursion(int numAppleLeft, int numPlate, int plateIdx, int minNumApple) {
        if (plateIdx == numPlate) {
            if (numAppleLeft == 0) return 1;
            else return 0;
        }
        if (plateIdx < numPlate && numAppleLeft < 1) return 0;

        int rst = 0;
        for (int n=minNumApple; n <= numAppleLeft; n++) {
            rst += recursion(numAppleLeft-n, numPlate, plateIdx+1, n);
        }
        return rst;
    }

    @Override
    public int count(int numApple, int numPlate) {
        return recursion(numApple, numPlate, 0, 0);
    }

}

class Memoization implements Solution {

    private int recursion(int numAppleLeft, int numPlate, int plateIdx, int minNumApple, int[][][] dp) {
        if (plateIdx == numPlate) {
            if (numAppleLeft == 0) return 1;
            else return 0;
        }
        if (plateIdx < numPlate && numAppleLeft < 1) return 0;
        if (dp[plateIdx][minNumApple][numAppleLeft] != -1) return dp[plateIdx][minNumApple][numAppleLeft];

        int rst = 0;
        for (int n=minNumApple; n <= numAppleLeft; n++) {
            rst += recursion(numAppleLeft-n, numPlate, plateIdx+1, n, dp);
        }

        dp[plateIdx][minNumApple][numAppleLeft] = rst;
        return rst;
    }

    @Override
    public int count(int numApple, int numPlate) {
        int[][][] dp = new int[numPlate][numApple+1][numApple+1];
        for (int[][] dpp: dp) {
            for (int[] r: dpp) Arrays.fill(r, -1);
        }

        return recursion(numApple, numPlate, 0, 0, dp);
    }

}
