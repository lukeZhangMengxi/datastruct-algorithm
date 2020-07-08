package patterns.merge_intervals.merge_intervals;

import java.util.ArrayList;
import java.util.List;


public class MergeIntervls extends Solution {

    @Override
    public List<Interval> merge(List<Interval> intervals) throws Exception {
        isValid(intervals);

        List<Interval> rst = new ArrayList<>();
        Interval buf = new Interval(-1, -1);
        for (Interval i: intervals) {
            if (buf.start == -1 && buf.end == -1) {
                buf.start = i.start;
                buf.end = i.end;
                continue;
            }

            if (i.start <= buf.end) {
                buf.end = i.end;
            } else {
                rst.add(new Interval(buf.start, buf.end));
                buf.start = i.start;
                buf.end = i.end;
            }
        }
        if (buf.start != -1 && buf.end != -1) {
            rst.add(new Interval(buf.start, buf.end));
        }

        return rst;
    }
    
}
