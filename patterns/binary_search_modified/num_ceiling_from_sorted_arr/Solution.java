package patterns.binary_search_modified.num_ceiling_from_sorted_arr;

interface Solution {
    int searchCeilingOfANumber(int[] arr, int key);    
}

class BinarySearch implements Solution {

    @Override
    public int searchCeilingOfANumber(int[] arr, int key) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return (arr[0] >= key) ? 0 : -1;

        int l=0, r=arr.length-1, mid=(l+r)/2;
        while (l<r) {
            if (arr[mid] == key) break;
            else if (arr[mid] > key) r = mid-1;
            else l = mid+1;

            mid = (l+r)/2;
        }
        
        if (arr[mid] >= key) return mid;
        else if (mid+1 < arr.length) return mid+1;
        else return -1;
    }

}
