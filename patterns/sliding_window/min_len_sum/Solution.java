package patterns.sliding_window.min_len_sum;

public abstract class Solution {
    abstract public int findMinSubArray(int s, int[] arr) throws Exception;

    protected void isValid(int s, int[] arr) throws Exception {
        for (int v : arr) {
            if (v < 0) {
                throw new Exception("Array contains negative value!");
            }
        }
    }
}
