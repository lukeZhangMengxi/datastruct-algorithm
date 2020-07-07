package patterns.two_pointers.remove_duplicates;

public class TwoPoints extends Solution {

    @Override
    public int remove(int[] arr) throws Exception {
        isValid(arr);

        if (arr.length == 0) return 0;

        int insertIdx=1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] != arr[insertIdx-1]) {
                arr[insertIdx] = arr[i];
                insertIdx++;
            }
        }
        return insertIdx;
    }
    
}