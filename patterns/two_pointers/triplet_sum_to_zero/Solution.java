package patterns.two_pointers.triplet_sum_to_zero;

import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    abstract public List<List<Integer>> searchTriplets(int[] arr) throws Exception;

    protected void isValid(int[] arr) throws Exception {
        
    }

    protected String encode(int a, int b, int c) {
        return a + "#" + b + "#" + c;
    }

    protected List<Integer> decode(String str) {
        String[] tmp = str.split("#");
        return Arrays.asList(Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]));
    }
}
