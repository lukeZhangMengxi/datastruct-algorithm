package patterns.cyclic_sort.cyclic_sort;

public class CyclicSort extends Solution {

    @Override
    public void sort(int[] nums) throws Exception {
        isValid(nums);

        for (int i=0; i<nums.length; i++) {
            int tmp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = tmp;
        }

    }
    
}