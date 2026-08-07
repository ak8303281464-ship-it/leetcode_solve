class Solution {
    public int searchInsert(int[] nums, int target) {
    int n = nums.length;
     int idx = 0;
     for(int i = 0; i<n; i++){
        if(nums[i] < target){
            idx++;
        }
     }
     return idx;
    }
}