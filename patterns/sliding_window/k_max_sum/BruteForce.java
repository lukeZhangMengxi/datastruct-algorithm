package patterns.sliding_window.k_max_sum;

public class BruteForce extends Solution {

    @Override
    public int findMaxSumSubArray(int k, int[] arr) throws Exception {
        isValid(k, arr);
        
        int rst = 0, curMax = 0;
        for (int i=0; i<arr.length-k+1; i++) {
            curMax = 0;
            for (int j=i; j<i+k; j++) curMax += arr[j];

            rst = Math.max(rst, curMax);
        }
        
        return rst;
    }
    
}