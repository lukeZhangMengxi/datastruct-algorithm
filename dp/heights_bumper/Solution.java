package dp.heights_bumper;

import java.util.Arrays;

interface Solution {

    public int numToRemoveToFormPike(int[] heights);

}

class Recursion implements Solution {

    private int recursion(int[] heights, int i, int lastHeight, boolean increasing, int removed) {
        if (i == heights.length) return removed;

        if (increasing) {   // Expecting increasing
            if (heights[i] > lastHeight) {  // Actually increasing
                return Math.min(
                    recursion(heights, i+1, heights[i], true, removed),
                    recursion(heights, i+1, lastHeight, true, removed+1)
                );
            } else if (heights[i] == lastHeight) {    // Actually equal
                return recursion(heights, i+1, lastHeight, true, removed+1);
            } else {    // Actually decreasing
                return Math.min(
                    recursion(heights, i+1, heights[i], false, removed),
                    recursion(heights, i+1, lastHeight, true, removed+1)
                );
            }
        } else {    // Expecting decreasing
            // Acutalling not increasing, has to remove/skip it
            if (heights[i] >= lastHeight) return recursion(heights, i+1, lastHeight, false, removed+1);

            // Actually decreasing
            return Math.min(
                recursion(heights, i+1, heights[i], false, removed),
                recursion(heights, i+1, lastHeight, false, removed+1)
            );
        }
    }

    @Override
    public int numToRemoveToFormPike(int[] heights) {
        return recursion(heights, 0, Integer.MIN_VALUE, true, 0);
    }

}

class Memoization implements Solution {

    private int recursion(int[] heights, int i, int lastHeightIdx, boolean increasing, int[][][] dp) {
        if (i == heights.length) return 0;
        int lastHeight = Integer.MIN_VALUE;
        if (lastHeightIdx != -1 && dp[increasing?1:0][i][lastHeightIdx] != -1) return dp[increasing?1:0][i][lastHeightIdx];
        if (lastHeightIdx != -1) lastHeight = heights[lastHeightIdx];

        int rst = 0;
        if (increasing) {   // Expecting increasing
            if (heights[i] > lastHeight) {  // Actually increasing
                rst = Math.min(
                    recursion(heights, i+1, i, true, dp),
                    recursion(heights, i+1, lastHeightIdx, true, dp) + 1
                );
            } else if (heights[i] == lastHeight) {    // Actually equal
                rst = recursion(heights, i+1, lastHeightIdx, true, dp) + 1;
            } else {    // Actually decreasing
                rst = Math.min(
                    recursion(heights, i+1, i, false, dp),
                    recursion(heights, i+1, lastHeightIdx, true, dp) + 1
                );
            }
        } else {    // Expecting decreasing
            // Acutalling not increasing, has to remove/skip it
            if (heights[i] >= lastHeight) rst = recursion(heights, i+1, lastHeightIdx, false, dp) + 1;
            else {
                // Actually decreasing
                rst =  Math.min(
                    recursion(heights, i+1, i, false, dp),
                    recursion(heights, i+1, lastHeightIdx, false, dp) + 1
                );
            }
        }

        if (lastHeightIdx != -1) {
            dp[increasing?1:0][i][lastHeightIdx] = rst;
        }
        return rst;
    }

    @Override
    public int numToRemoveToFormPike(int[] heights) {
        int[][][] dp = new int[2][heights.length][heights.length];
        for (int[][] rr: dp) for (int[] r: rr) Arrays.fill(r, -1);
        
        int rst = recursion(heights, 0, -1, true, dp);
        return rst;
    }

}
