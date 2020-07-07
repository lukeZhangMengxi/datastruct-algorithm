package patterns.two_pointers.pair_with_target_sum;

public class SqueezeSortedArray extends Solution {

    @Override
    public int[] search(int[] arr, int targetSum) throws Exception {
        isValid(arr, targetSum);

        int i=0, j=arr.length-1;
        while (i < j) {
            if (arr[i] + arr[j] == targetSum) {
                return new int[] {i, j};
            } else if (arr[i] + arr[j] > targetSum) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] {-1, -1};
    }
    
}