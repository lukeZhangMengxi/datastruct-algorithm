package sort.k_closest_points_to_origin;

import java.util.Arrays;

public class SimpleSort {

    public int[][] kClosest(int[][] points, int k) {
        int[] dists = new int[points.length];
        for (int i=0; i<points.length; i++) {
            dists[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }
        
        Arrays.sort(dists);

        int[][] rst = new int[k][];
        int bar = dists[k-1], index = 0;
        for (int i=0; i<points.length; i++) {
            if (points[i][0]*points[i][0] + points[i][1]*points[i][1] <= bar) {
                rst[index++] = points[i];
            }
        }

        return rst;
    }
}