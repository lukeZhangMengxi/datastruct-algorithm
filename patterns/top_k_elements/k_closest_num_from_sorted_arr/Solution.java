package patterns.top_k_elements.k_closest_num_from_sorted_arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

interface Solution {
    List<Integer> findClosestElements(int[] sortedArr, int k, int x);
}

class BinarySAndPriorityQ implements Solution {

    private int bs(int[] sortedArr, int x) {
        int l = 0, r = sortedArr.length-1, mid = (l+r)/2;
        while (l < mid) {
            if (mid < x) l = mid;
            else r = mid;
            
            mid = (l+r)/2;
        }
        return mid;
    }

    @Override
    @SuppressWarnings("serial")
    public List<Integer> findClosestElements(int[] sortedArr, int k, int x) {
        if (k == 0 || k > sortedArr.length) return Arrays.asList();

        PriorityQueue<Integer> q = new PriorityQueue<>(
            k+1,
            (a, b) -> Math.abs(b - x) - Math.abs(a - x)
        ){{
            int mid = bs(sortedArr, x);
            for (int i=mid-k; i<=mid+k; i++) {
                if (i >= 0 && i < sortedArr.length) this.add(sortedArr[i]);
            }
            while (this.size() > k) this.poll();
        }};

        
        return new ArrayList<Integer>() {{
            while (!q.isEmpty()) this.add(q.poll());
            Collections.sort(this);
        }};
    }

}