package patterns.sliding_window.k_average;

public class ReuseSubarraySum extends Solution {

    @Override
    public double[] findAverages(int k, int[] arr) throws Exception {
        isValid(k, arr);
        
        double sum = 0;
        for (int i=0; i<k; i++) sum += arr[i];
        double[] rst = new double[arr.length - k + 1];

        for (int i=0; i<rst.length; i++) {
            rst[i] = sum / k;
            sum -= arr[i];
            if (i+k < arr.length)
                sum += arr[i+k];
        }

        return rst;
    }
    
} 