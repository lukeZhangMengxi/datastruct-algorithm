package patterns.merge_intervals.merge_intervals;

import java.util.List;


public abstract class Solution {
    abstract public List<Interval> merge(List<Interval> intervals) throws Exception;

    protected void isValid(List<Interval> intervals) throws Exception {
        int prev = Integer.MIN_VALUE;
        for (Interval i: intervals) {
            if (i.start < prev)
                throw new IllegalArgumentException();
            prev = i.start;
        }
    }
}
