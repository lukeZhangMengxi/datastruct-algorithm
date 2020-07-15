package patterns.subset.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS extends Solution {

    boolean[] selected;

    @Override
    public List<List<Integer>> findPermutations(int[] nums) throws Exception {
        isValid(nums);

        selected = new boolean[nums.length];    // Default to false
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> buf = new LinkedList<>();

        dfs(nums, buf, rst);

        return rst;
    }

    private void dfs(int[] nums, List<Integer> buf, List<List<Integer>> rst) {
        if (nums.length == buf.size()) {
            rst.add(new ArrayList<>(buf));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                buf.add(nums[i]);

                dfs(nums, buf, rst);

                buf.remove(buf.size()-1);
                selected[i] = false;
            }
        }
    }


    
}