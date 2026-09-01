class Solution {
    public int minSubArrayLen(int tar, int[] nums) {
    int sum=0;
    int max=Integer.MAX_VALUE;
    int i=0;
    int j=0;
    while(j<nums.length){
        sum+=nums[j];
        while(sum>=tar){
            max=Math.min(max,j-i+1);
            sum-=nums[i];
            i++;
        }
        
            j++;
        


    }
    

    return max == Integer.MAX_VALUE ? 0 : max;


    }
}