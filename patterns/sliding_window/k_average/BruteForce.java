package patterns.sliding_window.k_average;


public class BruteForce extends Solution {

    @Override
    public double[] findAverages(int k, int[] arr) throws Exception {
        isValid(k, arr);

        double[] rst = new double[arr.length-k+1];
        for (int i=0; i<=arr.length-k; i++) {
            rst[i] = 0;
            for (int j=i; j<i+k; j++)
                rst[i] += arr[j];
            rst[i] /= k;
        }

        return rst;
    }
    
}
