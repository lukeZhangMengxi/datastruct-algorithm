package patterns.two_pointers.pair_with_target_sum;

public abstract class Solution {
    abstract public int[] search(int[] arr, int targetSum) throws Exception;

    protected void isValid(int[] arr, int targetSum) throws Exception {
        int prev = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v < prev) {
                throw new Exception("Array is not sorted");
            }
            prev = v;
        }
    }
}
