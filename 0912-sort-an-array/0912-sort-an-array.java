class Solution {
        static int[] helper(int[] arr,int s,int e){
        
         if(s==e){
            return new int[]{arr[s]};
         }

         int mid=s+(e-s)/2;
         // Corrected: passing 's' instead of hardcoded '0'
         int[] left=helper( arr,s,mid);
         int[] right=helper( arr,mid+1,e);
         int[] c=mergesort(left,right);
         return c;
    }
    static int[] mergesort(int[] left,int[] right){
        int i=0,j=0,k=0;

        int[] c=new int[left.length+right.length];
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                c[k++]=left[i++];
            }
            else{
                c[k++]=right[j++];
            }
            
        }
        while(i<left.length){
                  c[k++]=left[i++];

            }
            while(j<right.length){
                 c[k++]=right[j++];
            }
            return c;
    }
public int[] sortArray(int[] nums) {
   if(nums == null || nums.length == 0) return nums;
   int[] c =helper(nums,0,nums.length-1);
   return c;
    
}
}
