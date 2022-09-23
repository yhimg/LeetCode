class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i = 0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, n, nums, dp);
    }
    
    private int solve(int i, int prev_i, int[] arr, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][prev_i] != -1) return dp[i][prev_i];
        int take = 0;
        if(prev_i == arr.length || arr[i] > arr[prev_i])
            take = 1 + solve(i+1, i, arr, dp);
        int notTake = solve(i+1, prev_i, arr, dp);
        
        return dp[i][prev_i] = Math.max(take, notTake);
    }
}