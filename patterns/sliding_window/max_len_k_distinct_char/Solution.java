package patterns.sliding_window.max_len_k_distinct_char;

public abstract class Solution {
    abstract public int findLength(String str, int k) throws Exception;

    protected void isValid(String str, int k) throws Exception {
        if (str == null)
            throw new IllegalArgumentException();
    }
}
