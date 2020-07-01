package structure.stream.max_sum_subarray;

public class DivideConquer implements Solution {

    @Override
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    
    private int divide(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;
        int leftSum = divide(nums, left, mid);
        int rightSum = divide(nums, mid+1, right);
        int crossSum = merge(nums, left, right, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int merge(int[] nums, int l, int r, int mid) {
        if (l == r) return nums[l];

        int leftSubSum = Integer.MIN_VALUE;
        int cur = 0;
        for (int i=mid; i>=l; i--) {
            cur += nums[i];
            leftSubSum = Math.max(leftSubSum, cur);
        }

        int rightSubSum = Integer.MIN_VALUE;
        cur = 0;
        for (int i=mid+1; i<=r; i++) {
            cur += nums[i];
            rightSubSum = Math.max(rightSubSum, cur);
        }

        return leftSubSum + rightSubSum;
    }
}
