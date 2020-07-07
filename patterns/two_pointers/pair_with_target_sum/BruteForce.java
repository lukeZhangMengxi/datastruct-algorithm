package patterns.two_pointers.pair_with_target_sum;

public class BruteForce extends Solution {

    @Override
    public int[] search(int[] arr, int targetSum) throws Exception {
        isValid(arr, targetSum);

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (i != j && arr[i] + arr[j] == targetSum)
                    return new int[] {i, j};
            }
        }

        return new int[] {-1, -1};
    }
    
}