package structure.stream.product_array_except_self;

public class TwoSideDP implements Solution {

    @Override
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            l[i] = nums[i] * l[i-1];
        }

        r[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            r[i] = r[i+1] * nums[i];
        }

        for (int i=0; i<nums.length; i++) {
            int product = 1;
            if (i>0) product *= l[i-1];
            if (i<nums.length-1) product *= r[i+1];

            nums[i] = product;
        }
        
        return nums;
    }

}