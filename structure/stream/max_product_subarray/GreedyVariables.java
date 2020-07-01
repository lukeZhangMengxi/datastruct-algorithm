package structure.stream.max_product_subarray;

public class GreedyVariables implements Solution {

    @Override
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], rst = max;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.max(nums[i], nums[i] * min);

            rst = Math.max(rst, max);
        }

        return rst;
    }

}