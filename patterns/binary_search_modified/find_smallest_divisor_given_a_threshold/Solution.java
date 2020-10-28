package patterns.binary_search_modified.find_smallest_divisor_given_a_threshold;

public class Solution {

    public long compute(int[] nums, int divisor) {
        long result = 0;
        for (int n : nums) {
            result += n / divisor;
            if (n % divisor != 0) result++;
        }
        return result;
    }

    public int getRight(int[] nums, int th) {
        int right = 2;
        while (compute(nums, right) > th) {
            right <<= 1;
        }
        return right;
    }

    public int binarySearch(int[] nums, int th, int l, int r) {
        if (r == l+1) {
            return (compute(nums, l) <= th) ? l : r;
        }
        
        int mid = (l+r) / 2;
        if (compute(nums, mid) <= th) {
            return binarySearch(nums, th, l, mid);
        } else {
            return binarySearch(nums, th, mid, r);
        }
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1, right = getRight(nums, threshold);
        return binarySearch(nums, threshold, left, right);
    }
}
