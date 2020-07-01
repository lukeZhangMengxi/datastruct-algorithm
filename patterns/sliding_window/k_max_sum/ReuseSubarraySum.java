package patterns.sliding_window.k_max_sum;

public class ReuseSubarraySum extends Solution {

    @Override
    public int findMaxSumSubArray(int k, int[] arr) throws Exception {
        isValid(k, arr);

        int rst=0, curMax=0, l=0, r=0;
        while (l < arr.length-k+1) {
            while (r < l+k) {
                curMax += arr[r++];
            }

            rst = Math.max(rst, curMax);

            curMax -= arr[l++];
        }

        return rst;
    }
    
}