package sort.k_closest_points_to_origin;

import java.util.PriorityQueue;

public class FixLengthPriorityQueue implements Solution {
    
    @Override
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k+1, (b, a) ->
            a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]
        );

        // O(N*log(K))
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) pq.poll();
        }

        int[][] rst = new int[pq.size()][];
        int idx = 0;
        while (!pq.isEmpty()) {
            rst[idx++] = pq.poll();
        }
        return rst;
    }
}
