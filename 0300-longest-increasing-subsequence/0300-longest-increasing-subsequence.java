class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i = n-1; i>=0; i--){
            for(int j = n; j>=0; j--){
                int take = 0;
                if(j == n || nums[i] > nums[j])
                    take = 1 + dp[i+1][i];
                int notTake = dp[i+1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[0][n];
        
        
        
        // int[][] dp = new int[n+1][n+1];
        // return solve(0, n, nums, dp);
    }
    
    private int solve(int i, int prev_i, int[] nums, int[][] dp){
        if(i == nums.length)
            return 0;
        if(dp[i][prev_i] != 0) return dp[i][prev_i];
        int take = 0;
        if(prev_i == nums.length || nums[i] > nums[prev_i]){
            take = 1 + solve(i+1, i, nums, dp);
        }
        int notTake = solve(i+1, prev_i, nums, dp);
        return dp[i][prev_i] = Math.max(take, notTake);
    }
}