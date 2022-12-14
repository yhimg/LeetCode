class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        Arrays.fill(dp, -1);
        return solve(len-1, nums, dp);
    }
    
    private int solve(int ind, int[] arr, int[] dp){
        if(ind < 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int robCurr = arr[ind] + solve(ind-2, arr, dp);
        
        int notRobCurr = solve(ind-1, arr, dp);
        
        return dp[ind] = Math.max(robCurr, notRobCurr);
    }
}