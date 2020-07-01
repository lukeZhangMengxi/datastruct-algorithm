package structure.sort.k_closest_points_to_origin;

import java.util.Arrays;

public class QuickSort implements Solution {

	@Override
	public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length-1;
        while (left < right) {
            int mid = quickSort(points, left, right);
            if (mid == k) return Arrays.copyOfRange(points, 0, k);
            else if (mid > k) right = mid - 1;
            else left = mid + 1;
        }
		return Arrays.copyOfRange(points, 0, k);
    }

    private int quickSort(int[][] points, int left, int right) {
        int[] pivot = points[left];
        while (left < right) {
            while (left < right && dist(points[right]) >= dist(pivot)) right--;
            points[left] = points[right];

            while (left < right && dist(points[left]) < dist(pivot)) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        return left;
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

}