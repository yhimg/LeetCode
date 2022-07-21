class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int product = 1;
        int count = 0;
        
        
        /*for(int i=0; i<nums.length; i++){
            
            for(int j=i; j<nums.length; j++){
                product *= nums[j];
                if(product >= k) break;
                count++;
            }
            product = 1;
        }*/
        
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            product *= nums[right];
            while(product >= k) product /= nums[left++];
            count += right - left +1;
        }
        
        
        return count;
    }
}