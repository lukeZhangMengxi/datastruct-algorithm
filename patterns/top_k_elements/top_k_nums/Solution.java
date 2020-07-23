package patterns.top_k_elements.top_k_nums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

interface Solution {

    List<Integer> findKLargestNumbers(int[] nums, int k);
 
}

class PriorityQ implements Solution {

    @Override
    public List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k+1);

        for (int v: nums) {
            q.add(v);
            if (q.size()>k) q.poll();
        }
        return new ArrayList<>(q);
    }

}
