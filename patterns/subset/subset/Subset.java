package patterns.subset.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset extends Solution {

    @Override
    public List<List<Integer>> findSubsets(int[] nums) throws Exception {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);

        rst.add(new ArrayList<>());
        int startIdx = 0, endIdx = 0;
        for (int j=0; j<nums.length; j++) {
            startIdx = 0;
            if (j>0 && nums[j] == nums[j-1])
                startIdx = endIdx + 1;
            endIdx = rst.size()-1;

            for (int i=startIdx; i<=endIdx; i++) {
                List<Integer> next = new ArrayList<>(rst.get(i));
                next.add(nums[j]);
                rst.add(next);
            }
        }

        return rst;
    }
    
}