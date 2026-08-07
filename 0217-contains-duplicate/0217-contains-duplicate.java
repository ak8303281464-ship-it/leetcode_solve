class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> con=new HashSet<>();
        for(int x : nums){
            if(!con.add(x)){
                return true;
            }
        }
        return false;
    }
}