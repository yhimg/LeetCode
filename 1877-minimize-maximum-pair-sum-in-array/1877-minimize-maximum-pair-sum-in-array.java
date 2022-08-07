class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length-1;
        int max = 0;
        while(low<high){
            max = Math.max(nums[low++]+nums[high--], max);
        }
        return max;
    }
}