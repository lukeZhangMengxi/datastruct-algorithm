package patterns.xor.find_missing_num;

interface Solution {
    int findMissingNumber(int[] arr);    
}

class Regular implements Solution {

    @Override
    public int findMissingNumber(int[] arr) {
        long total = (1 + arr.length+1)*(arr.length+1)/2;
        for (int v: arr) total -= v;
        return (int)total;
    }

}

class Xor implements Solution {

    @Override
    public int findMissingNumber(int[] arr) {
        if (arr.length == 0) return -1;

        int arrXor = 0;
        int totalXor = arr[0];
        for (int i=1; i<arr.length; i++) {
            totalXor ^= i;
            arrXor ^= arr[i];
        }
        totalXor ^= (arr.length);
        totalXor ^= (arr.length+1);

        return totalXor ^ arrXor;
    }

}
