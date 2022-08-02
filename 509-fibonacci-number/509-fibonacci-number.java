class Solution {
    public int fib(int n) {
        int dp[] = new int[n+2];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return solve(n, dp);
    }
    
    private int solve(int n, int[] dp){
        if(n <= 1) return dp[n];
        if(dp[n] == -1){
            dp[n] =  solve(n-1, dp) + solve(n-2, dp);
            return dp[n];
        }
        else return dp[n];
    }
    
    
}