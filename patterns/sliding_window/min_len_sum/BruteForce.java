package patterns.sliding_window.min_len_sum;

public class BruteForce extends Solution {

    @Override
    public int findMinSubArray(int s, int[] arr) throws Exception {
        isValid(s, arr);
        
        int rst = arr.length + 1;
        for (int i=0; i<arr.length; i++) {
            int curSum = 0;
            for (int j=i; j<arr.length; j++) {
                curSum += arr[j];
                if (curSum >= s)
                    rst = Math.min(rst, j-i+1);
            }
        }
        
        return rst > arr.length ? -1 : rst;
    }
    
}