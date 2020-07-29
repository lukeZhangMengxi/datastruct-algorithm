package random_questions.five;

import java.util.LinkedList;
import java.util.List;

class BacktrackDFS implements Solution {

    private int rst = 0;

    @Override
    public int getMaxSteps(int[] heights) {

        select(heights, 0, new LinkedList<>());
        
        return rst;
    }

    private void select(int[] heights, int idx, List<Integer> buf) {
        if (idx == heights.length) {
            rst = Math.max(rst, buf.size());
            return;
        }

        for (int i=idx; i<heights.length; i++) {
            if (!buf.isEmpty() && heights[i] <= buf.get(buf.size()-1)) continue;

            buf.add(heights[i]);
            select(heights, idx+1, buf);
            buf.remove(buf.size()-1);
            select(heights, idx+1, buf);
        }
    }

}
