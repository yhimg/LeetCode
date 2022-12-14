class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        
        for(int i = 1; i<len; i++){
            int take = nums[i];
            int notTake = 0;
            if(i > 1){
                take += dp[i-2];
            } 
            notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
            
        }
        return dp[len-1];
        
        
        // Arrays.fill(dp, -1);
        // return solve(len-1, nums, dp);
    }
    
    private int solve(int ind, int[] arr, int[] dp){
        if(ind < 0) return 0;
        
        if(ind == 0) return arr[0];
        
        if(dp[ind] != -1) return dp[ind];
        
        int robCurr = arr[ind] + solve(ind-2, arr, dp);
        
        int notRobCurr = solve(ind-1, arr, dp);
        
        return dp[ind] = Math.max(robCurr, notRobCurr);
    }
}