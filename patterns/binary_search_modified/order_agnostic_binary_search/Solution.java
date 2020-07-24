package patterns.binary_search_modified.order_agnostic_binary_search;

interface Solution {

    int searchIndex(int[] arr, int key);

}

class BinarySearch implements Solution {

    @Override
    public int searchIndex(int[] arr, int key) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0]==key ? 0 : -1;

        boolean isIncreasing = (arr[0] < arr[arr.length-1]);
        int l=0, r=arr.length-1, mid = (l+r)/2;
        while (l < r) {
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) {
                if (isIncreasing) r = mid-1;
                else l = mid+1;
            } else {
                if (isIncreasing) l = mid+1;
                else r = mid-1;
            }
            mid = (l+r)/2;
        }
        return arr[mid]==key ? mid : -1;
    }

}
