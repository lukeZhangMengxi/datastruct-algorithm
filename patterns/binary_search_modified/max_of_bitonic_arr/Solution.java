package patterns.binary_search_modified.max_of_bitonic_arr;

interface Solution {
    int findMax(int[] arr);    
}

class LinearSearch implements Solution {

    @Override
    public int findMax(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];

        int l=0, r=arr.length-1, mid=(r+l)/2;
        while (l<r) {
            if (arr[mid] <= arr[r] && arr[l] < arr[r]) l=r;
            else if (arr[r] < arr[l] && arr[mid] <= arr[l]) r = l;
            else if (arr[mid] > arr[l] && arr[mid] > arr[r]) {
                l++;
                r--;
            } else {
                // Exception
            }

            mid=(r+l)/2;
        }

        return arr[mid];
    }

}

class BinarySearch implements Solution {

    @Override
    public int findMax(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];

        int l=0, r=arr.length-1, mid=(r+l)/2;
        while (l<r) {
            if (arr[mid] > arr[mid+1]) {
                r = mid;
            } else {
                l = mid+1;
            }
            mid=(r+l)/2;
        }

        return arr[mid];
    }

}
