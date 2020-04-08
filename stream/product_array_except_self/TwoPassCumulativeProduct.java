package stream.product_array_except_self;

public class TwoPassCumulativeProduct implements Solution {

    @Override
    public int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];

        rst[0] = 1;
        for (int i=1; i<nums.length; i++) {
            rst[i] = rst[i-1] * nums[i-1];
        }

        int rightCumulativeProduct = 1;
        for (int i=nums.length-1; i>=0; i--) {
            rst[i] *= rightCumulativeProduct;
            rightCumulativeProduct *= nums[i];
        }

        return rst;
    }

}