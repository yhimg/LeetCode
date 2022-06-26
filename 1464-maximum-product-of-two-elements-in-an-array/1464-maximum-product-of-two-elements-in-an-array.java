class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length-1;
        
        return (nums[j] -1) * (nums[j-1] -1) ;
    }
}