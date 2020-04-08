package stream.max_sum_subarray;

public class GreedyVariable implements Solution {

    @Override
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE, curSum = Integer.MIN_VALUE;
        for (int val : nums) {
            curSum = Math.max(curSum + val, val);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }

}