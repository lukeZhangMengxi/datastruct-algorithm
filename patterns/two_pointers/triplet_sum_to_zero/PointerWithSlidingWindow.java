package patterns.two_pointers.triplet_sum_to_zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointerWithSlidingWindow extends Solution {

    @Override
    public List<List<Integer>> searchTriplets(int[] arr) throws Exception {
        isValid(arr);
        Arrays.sort(arr);

        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i<arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) i++;
            else {
                List<String> tmp = helper(i+1, arr, -arr[i]);
                for (String s: tmp) {
                    rst.add(decode(s));
                }
            }
        }

        return rst;
    }

    private List<String> helper(int startIdx, int[] arr, int target) {

        List<String> rst = new ArrayList<>();

        int i = startIdx, j = arr.length-1;
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                if (arr[i] != arr[i-1]) rst.add(encode(arr[startIdx-1], arr[i], arr[j]));

                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return rst;
    }
    
}