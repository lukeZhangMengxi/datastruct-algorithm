package stream.max_product_subarray;

public class HardDP implements Solution {

    @Override
    public int maxProduct(int[] nums) {
        State[] dp = new State[nums.length];
        dp[0] = new State(nums[0], nums[0]);
        int rst = dp[0].max;
        for (int i=1; i<nums.length; i++) {
            State prev = dp[i-1];
            int newMax = Math.max(Math.max(nums[i], nums[i] * prev.max), nums[i] * prev.min);
            int newMin = Math.max(Math.max(nums[i], nums[i] * prev.min), nums[i] * prev.max);

            dp[i] = new State(newMax, newMin);
            rst = Math.max(rst, newMax);
        }

        return rst;
    }

    private class State {
        int max, min;
        State(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

}
