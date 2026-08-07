class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even to compare with mid + 1
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair matches, single element is on the right half
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else { // Otherwise, single element is on the left half (or at mid)
                right = mid;
            }
        }

        return nums[left];
    }
}