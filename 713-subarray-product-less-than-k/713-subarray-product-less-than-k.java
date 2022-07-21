class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int count = 0;
        
        
        for(int i=0; i<nums.length; i++){
            
            for(int j=i; j<nums.length; j++){
                product *= nums[j];
                if(product >= k) break;
                count++;
            }
            product = 1;
        }
        return count;
    }
}