class Solution { //array sliding window
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<k; i++){
            sum=sum+nums[i];

        }
        int maxSum=sum;
        int low=1;
        int high=k;
        while(high<nums.length){
            sum=sum+nums[high]-nums[low-1];
            maxSum=Math.max(maxSum,sum);
            low++;
            high++;

        }
        return (double)maxSum/k;
        
    }
}