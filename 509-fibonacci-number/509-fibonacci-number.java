class Solution {
    public int fib(int n) {
        /*int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);*/
        
        if(n < 1) return n;
        int prev = 1;
        int prev2 = 0;
        for(int i = 2; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    private int solve(int n, int[] dp){
        if(n <=1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1, dp)+solve(n-2, dp);
    }
}