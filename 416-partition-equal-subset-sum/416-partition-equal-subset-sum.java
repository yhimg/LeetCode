class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum %2 != 0 ) return false;
        int[][] dp = new int[nums.length][sum+1];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, sum/2, nums, dp);
    }
    
    private boolean solve(int index, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(index == arr.length) return false;
        
        if(dp[index][target] != -1) return dp[index][target] == 1 ? true : false;
        boolean take = false;
        if(arr[index] <= target) take = solve(index+1, target-arr[index], arr, dp);
        boolean notTake = solve(index+1, target, arr, dp);
        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}