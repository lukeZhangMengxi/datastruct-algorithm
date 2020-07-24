package patterns.binary_search_modified.number_range_from_sorted_arr;

import java.util.Arrays;

interface Solution {
    int[] findRange(int[] arr, int key);    
}

class BinarySearch implements Solution {

    @Override
    public int[] findRange(int[] arr, int key) {
        if (arr.length == 0) return new int[]{-1, -1};
        if (arr.length == 1) return (arr[0] == key) ? new int[] {0, 0} : new int[] {-1, -1};

        int idx = Arrays.binarySearch(arr, key);
        if (idx < 0) return new int[]{-1, -1};

        int l=idx, r=idx;
        while (l-1>=0 && arr[l-1]==key) l--;
        while (r+1<arr.length && arr[r+1]==key) r++;
        return new int[] {l, r};
    }

}
