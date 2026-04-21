class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            // THE SHORTCUT: If the current search space is already sorted, 
            // the minimum is strictly at the left boundary.
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int mid = l + (r - l) / 2;
            
            // Standard binary search squeeze
            if (nums[mid] > nums[r]) {
                // The drop-off is to the right
                l = mid + 1;
            } else {
                // The drop-off is at mid or to the left
                r = mid;
            }
        }

        // Return the final converged pointer
        return nums[l]; // or nums[r], they are equal here!
    }
}