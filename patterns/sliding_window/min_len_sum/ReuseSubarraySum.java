package patterns.sliding_window.min_len_sum;

public class ReuseSubarraySum extends Solution {

    @Override
    public int findMinSubArray(int s, int[] arr) throws Exception {
        isValid(s, arr);

        int windowStart=0, windowEnd=0, curSum=0, rst=arr.length;
        while (windowEnd < arr.length) {
            while (curSum < s && windowEnd < arr.length) {
                curSum += arr[windowEnd++];
            }

            // the current windowEnd is one off
            rst = Math.min(rst, windowEnd - windowStart);

            curSum -= arr[windowStart++];
        }

        return rst;
    }
    
}