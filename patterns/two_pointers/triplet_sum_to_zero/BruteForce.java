package patterns.two_pointers.triplet_sum_to_zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce extends Solution {

    @Override
    public List<List<Integer>> searchTriplets(int[] arr) throws Exception {
        isValid(arr);

        Arrays.sort(arr);
        Set<String> buf = new HashSet<>();

        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                for (int k=j+1; k<arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0)
                        buf.add(encode(arr[i], arr[j], arr[k]));
                }
            }
        }

        for (String element: buf)
            rst.add(decode(element));

        return rst;
    }

    private String encode(int a, int b, int c) {
        return a + "#" + b + "#" + c;
    }

    private List<Integer> decode(String str) {
        String[] tmp = str.split("#");
        return Arrays.asList(Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]));
    }
    
}