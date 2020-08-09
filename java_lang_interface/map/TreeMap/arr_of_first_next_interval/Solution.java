package java_lang_interface.map.TreeMap.arr_of_first_next_interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

interface Solution {
    int[] findRightInterval(int[][] intervals);    
}

class UseTreeMap implements Solution {

    @Override
    @SuppressWarnings("serial")
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> m = new TreeMap<>() {{
            for (int i=0; i<intervals.length; i++) this.put(intervals[i][0], i);
        }};

        int[] rst = new int[intervals.length];
        for (int i=0; i<rst.length; i++) {
            Map.Entry<Integer, Integer> e = m.ceilingEntry(intervals[i][1]);
            rst[i] = (e==null) ? -1 : e.getValue();
        }
        return rst;
    }

}

class SortBinarySearch implements Solution {

    private int[] bsForNextInterval(int[][] sortedArr, int targetStart) {
        int i=0, j=sortedArr.length-1;
        while (i<j) {
            int mid = (i+j) / 2;
            if (sortedArr[mid][0] == targetStart) return sortedArr[mid];
            else if (sortedArr[mid][0] > targetStart) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }

        if (sortedArr[j][0] < targetStart) {
            if (j < sortedArr.length-1) j++;
            else return null;
        }

        return sortedArr[j];
    }

    @Override
    @SuppressWarnings("serial")
    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> originalIndex = new HashMap<>() {{
            for (int i=0; i<intervals.length; i++) this.put(intervals[i], i);
        }};

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] rst = new int[intervals.length];
        for (int[] interval: intervals) {
            int idx = originalIndex.get(interval);
            int[] next = bsForNextInterval(intervals, interval[1]);
            int nextIntervalIdx = next==null ? -1: originalIndex.get(next);

            rst[idx] = nextIntervalIdx;
        }
        return rst;
    }

}
