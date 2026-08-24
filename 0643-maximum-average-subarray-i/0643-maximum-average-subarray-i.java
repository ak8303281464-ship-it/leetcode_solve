class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Initialize the sum of the first k elements
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        // This will track our maximum sum across all windows
        int maxSum = currentSum;
        
        // Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Add the new element entering the window and subtract the one leaving
            currentSum += nums[i] - nums[i - k];
            // Track the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the maximum average by converting to double
        return (double) maxSum / k;
    }
}
