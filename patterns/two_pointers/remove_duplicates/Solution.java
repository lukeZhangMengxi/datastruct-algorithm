package patterns.two_pointers.remove_duplicates;

public abstract class Solution {
    abstract public int remove(int[] arr) throws Exception;

    protected void isValid(int[] arr) throws Exception {
        int prev = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v < prev) {
                throw new Exception("Array is not sorted");
            }
            prev = v;
        }
    }
}
