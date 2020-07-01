package patterns.sliding_window.k_average;

public abstract class Solution {
    abstract public double[] findAverages(int k, int[] arr) throws Exception;

    protected void isValid(int k, int[] arr) throws Exception {
        if (arr.length < k)
            throw new Exception("Array length smaller than k.");
    }
}
