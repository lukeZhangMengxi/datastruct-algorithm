package patterns.merge_intervals.label_partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


interface Solution {
    List<Integer> partitionLabels(String S);    
}

@SuppressWarnings("serial")
class MS implements Solution {

    @Override
    public List<Integer> partitionLabels(String S) {
        // Get intervals
        Map<Character, int[]> record = new HashMap<>() {{
            for (int i=0; i<S.length(); i++) {
                if (this.containsKey(S.charAt(i))) this.get(S.charAt(i))[1] = i;
                else this.put(S.charAt(i), new int[] {i, i});
            }
        }};
        List<int[]> intervals = new LinkedList<>() {{
            for (int[] interval: record.values()) this.add(interval);
            this.sort((a, b) -> a[0] - b[0]);
        }};

        // While there are overlap, merge intervals
        int i = 0;
        while (i < intervals.size()-1) {
            if (intervals.get(i)[1] > intervals.get(i+1)[0]) {
                intervals.get(i)[1] = Math.max(intervals.get(i)[1], intervals.get(i+1)[1]);
                intervals.remove(i+1);
            } else {
                i++;
            }
        }

        // Construct result
        return new ArrayList<>() {{
            for (int[] interval: intervals) this.add(interval[1] - interval[0] + 1);
        }};
    }

}
