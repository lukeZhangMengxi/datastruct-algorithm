package patterns.top_k_elements.top_k_frequent_num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

interface Solution {
    List<Integer> findTopKFrequentNumbers(int[] nums, int k);    
}

class PriorityQ implements Solution {

    @Override
    @SuppressWarnings("serial")
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        
        
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>() {{
            for (int n: nums) this.put(n, this.getOrDefault(n, 0) + 1);
        }};

        PriorityQueue<Integer> q = new PriorityQueue<>(
            k+1,
            (a, b) -> freq.get(a) - freq.get(b)
        ) {{
            for (int n: freq.keySet()) {
                this.add(n);
                if (this.size() > k) this.poll();
            }
        }};

        return new ArrayList<>(q);
    }

}
