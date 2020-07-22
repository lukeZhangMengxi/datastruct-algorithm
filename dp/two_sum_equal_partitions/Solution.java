package dp.two_sum_equal_partitions;

interface Solution {
    
    boolean canPartition(int[] nums);

}

class Recursion implements Solution {

    private boolean recursion(int[] nums, int i, int sum) {
        if (i == nums.length) return sum == 0;

        return recursion(nums, i+1, sum + nums[i])
                || recursion(nums, i+1, sum - nums[i]);
        
    }

    @Override
    public boolean canPartition(int[] nums) {
        return recursion(nums, 0, 0);
    }

}

class Memoization implements Solution {

    private boolean recursion(int[] nums, int i, int sum, Boolean[][] dp, int expected) {
        if (i == nums.length) return sum == expected;
        if (dp[i][sum] != null) return dp[i][sum];

        boolean rst = recursion(nums, i+1, sum + nums[i], dp, expected)
                        || recursion(nums, i+1, sum - nums[i], dp, expected);

        dp[i][sum] = rst;
        return rst;
    }

    @Override
    public boolean canPartition(int[] nums) {

        int total = 0;
        for (int v: nums) total+=v;

        return recursion(nums, 0, total, new Boolean[nums.length][2*total+1], total);
    }

}

class SmarterRecursion implements Solution {

    private boolean recursion(int[] nums, int target, int i) {
        if (i == nums.length) return target == 0;
        
        if (nums[i] <= target) {
            if (recursion(nums, target-nums[i], i+1)) return true;
        }

        return recursion(nums, target, i+1);
    }

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int v: nums) sum += v;
        if (sum%2 != 0) return false;

        return recursion(nums, sum/2, 0);
    }

}

class SmarterMemoization implements Solution {

    private boolean recursion(int[] nums, int target, int i, Boolean[][] dp) {
        if (i == nums.length) return target == 0;
        if (dp[i][target] != null) return dp[i][target];
        
        if (nums[i] <= target) {
            if (recursion(nums, target-nums[i], i+1, dp)) {
                dp[i][target] = true;
                return true;
            }
        }

        dp[i][target] = recursion(nums, target, i+1, dp);
        return dp[i][target];
    }

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int v: nums) sum += v;
        if (sum%2 != 0) return false;

        return recursion(nums, sum/2, 0, new Boolean[nums.length][sum/2+1]);
    }

}

class Tabulation implements Solution {

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int v: nums) sum += v;
        if (sum%2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[nums.length][sum+1];
        for (int i=0; i<nums.length; i++) dp[i][0] = true;

        for (int i=1; i<nums.length; i++) {
            for (int s=1; s<=sum; s++) {
                if (dp[i-1][s]) dp[i][s] = true;
                else if (s >= nums[i]) dp[i][s] = dp[i-1][s-nums[i]];
            }
        }
        
        return dp[nums.length-1][sum];
    }

}

class SmartTabulation implements Solution {

    @Override
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int v: nums) sum += v;
        if (sum%2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[2][sum+1];
        for (int i=0; i<nums.length; i++) dp[i%2][0] = true;

        for (int i=1; i<nums.length; i++) {
            for (int s=1; s<=sum; s++) {
                if (dp[(i+1)%2][s]) dp[i%2][s] = true;
                else if (s >= nums[i]) dp[i%2][s] = dp[(i+1)%2][s-nums[i]];
            }
        }
        
        return dp[(nums.length-1)%2][sum];
    }

}
