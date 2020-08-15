package patterns.top_k_elements.kth_largest_element;

import java.util.Random;

interface Solution {
    int findKthLargest(int[] nums, int k);    
}

class QuickSelect implements Solution {

    Random random_num;

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
	}
	
	public int partition(int[] nums, int left, int right, int pivot_index) {
		int pivot = nums[pivot_index];
		// 1. move pivot to end
		swap(nums, pivot_index, right);
		int store_index = left;
	
		// 2. move all smaller elements to the left
		for (int i = left; i <= right; i++) {
		  if (nums[i] < pivot) {
			swap(nums, store_index, i);
			store_index++;
		  }
		}
	
		// 3. move pivot to its final place
		swap(nums, store_index, right);
	
		return store_index;
	}

    public int quickSelect(int[] nums, int left, int right, int k_smallest) {
        /*
        Returns the k-th smallest element of list within left..right.
        */
    
        if (left == right) // If the list contains only one element,
          return nums[left];  // return that element
    
        // select a random pivot_index
        int pivot_index = left + random_num.nextInt(right - left); 
        
        pivot_index = partition(nums, left, right, pivot_index);
    
        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
          return nums[k_smallest];
        // go left side
        else if (k_smallest < pivot_index)
          return quickSelect(nums, left, pivot_index - 1, k_smallest);
        // go right side
        return quickSelect(nums, pivot_index + 1, right, k_smallest);
    }

    @Override
    public int findKthLargest(int[] nums, int k) {
        random_num = new Random();
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

}
