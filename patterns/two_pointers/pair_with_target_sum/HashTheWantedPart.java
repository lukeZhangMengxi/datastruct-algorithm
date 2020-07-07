package patterns.two_pointers.pair_with_target_sum;

import java.util.*;

public class HashTheWantedPart extends Solution {

    @Override
    public int[] search(int[] arr, int targetSum) throws Exception {
        isValid(arr, targetSum);

        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int curVal = arr[i];
            int wanted = targetSum - curVal;
            if (m.containsKey(wanted)) {
                return new int[] {m.get(wanted), i};
            }

            m.put(curVal, i);
        }
        
        return new int[] {-1, -1};
    }
    
}