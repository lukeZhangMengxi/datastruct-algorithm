package stream.max_sum_subarray;

public class HardDP implements Solution {

    @Override
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int curSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            dp[i] = Math.max(dp[i-1], curSum);
        }

        return dp[nums.length-1];
    }

}