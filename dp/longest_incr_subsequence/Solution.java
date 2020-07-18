package dp.longest_incr_subsequence;

import java.util.Arrays;

interface Solution {
    
    int lenOfLongestIncrSubsequence(int[] nums);

}

class Recursion implements Solution {

    private int recursion(int[] nums, int lastNum, int i) {
        if (i == nums.length) return 0;
        if (nums[i] <= lastNum) return recursion(nums, lastNum, i+1);

        return Math.max(
            recursion(nums, lastNum, i+1),          // Ignore this value
            recursion(nums, nums[i], i+1) + 1       // Pick this value
        );
    }

    @Override
    public int lenOfLongestIncrSubsequence(int[] nums) {
        return recursion(nums, Integer.MIN_VALUE, 0);
    }

}

class Memoization implements Solution {

    private int recursion(int[] nums, int lastNumIdx, int i, int[][] dp) {
        if (i == nums.length) return 0;
        if (lastNumIdx != -1 && dp[lastNumIdx][i] != -1) return dp[lastNumIdx][i];
        if (lastNumIdx != -1 && nums[i] <= nums[lastNumIdx]) return recursion(nums, lastNumIdx, i+1, dp);

        int rst = Math.max(
            recursion(nums, lastNumIdx, i+1, dp),   // Ignore this value
            recursion(nums, i, i+1, dp) + 1         // Pick this value
        );
        if (lastNumIdx != -1) dp[lastNumIdx][i] = rst;
        return rst;
    }

    @Override
    public int lenOfLongestIncrSubsequence(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] r: dp) Arrays.fill(r, -1);

        int rst = recursion(nums, -1, 0, dp);
        return rst;
    }

}
