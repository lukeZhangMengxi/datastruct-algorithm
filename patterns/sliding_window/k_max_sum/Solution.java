package patterns.sliding_window.k_max_sum;

public abstract class Solution {
    abstract public int findMaxSumSubArray(int k, int[] arr) throws Exception;

    protected void isValid(int k, int[] arr) throws Exception {
        if (arr.length < k)
            throw new Exception("Array length smaller than k.");
    }
}
