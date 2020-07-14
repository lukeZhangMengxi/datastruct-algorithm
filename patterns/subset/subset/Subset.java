package patterns.subset.subset;

import java.util.ArrayList;
import java.util.List;

public class Subset extends Solution {

    @Override
    public List<List<Integer>> findSubsets(int[] nums) throws Exception {
        List<List<Integer>> rst = new ArrayList<>();

        rst.add(new ArrayList<>());
        for (int n: nums) {
            int size = rst.size();
            for (int i=0;i<size; i++) {
                List<Integer> next = new ArrayList<>(rst.get(i));
                next.add(n);
                rst.add(next);
            }
        }

        return rst;
    }
    
}