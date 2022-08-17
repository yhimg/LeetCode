class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        
        for(int i = 0; i<=n; i++){
            if(i <= 1){
                dp[i] = i;
            } else 
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        //Arrays.fill(dp, -1);
        //return solve(n, dp);
    }
    
    public int solve(int n, int[] dp) {
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1, dp)+solve(n-2, dp);
    }
}