package structure.two_d.tree.segment_tree.range_sum_update_and_query;

public interface Solution {
    void init(int[] nums);
    void update(int i, int val);
    int rangeSum(int i, int j);
}

class UseSegmengTree implements Solution {

    int[] segTree;

    @Override
    public void init(int[] nums) {
        if (nums != null && nums.length > 0) {
            segTree = new int[nums.length * 2];

            for (int i=nums.length; i<segTree.length; i++) segTree[i] = nums[i-nums.length];

            for (int i=nums.length-1; i>0; i--) segTree[i] = segTree[2*i] + segTree[2*i+1];
        }
    }

    @Override
    public void update(int i, int val) {
        int idx = i+segTree.length/2;
        segTree[idx] = val;

        while (idx > 0) {
            if (idx%2 != 0) idx--;

            segTree[idx/2] = segTree[idx] + segTree[idx+1];
            idx/=2;
        }

    }

    @Override
    public int rangeSum(int i, int j) {
        // Assume i,j valid

        int a = i + segTree.length/2;
        int b = j + segTree.length/2;

        int sum = 0;
        while (a <= b) {
            if (a%2 != 0) sum += segTree[a++];
            if (b%2 == 0) sum += segTree[b--];
            a /= 2;
            b /= 2;
        }

        return sum;
    }

}

class BruteForce implements Solution {

    int[] arr;

    @Override
    public void init(int[] nums) {
        arr = nums;
    }

    @Override
    public void update(int i, int val) {
        arr[i] = val;
    }

    @Override
    public int rangeSum(int i, int j) {
        int sum = 0;
        for (int idx=i; idx<=j; idx++) sum += arr[idx];
        return sum;
    }

}
