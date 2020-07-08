package patterns.cyclic_sort.find_missing_number;

public class CyclicSort extends Solution {

    @Override
    public int findMissingNumber(int[] nums) throws Exception {
        isValid(nums);

        int idx=0;
        while (idx < nums.length) {
            if (nums[idx] < nums.length && nums[idx] != nums[nums[idx]])
                swap(nums, idx, nums[idx]);
            else
                idx++;
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i) return i;   
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
