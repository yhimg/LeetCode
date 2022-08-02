class Solution {
    public int fib(int n) {
        //int dp[] = new int[n+1];
        //Arrays.fill(dp, -1);
        //return solve(n, dp);
        
        int prev1 = 1;
        int prev2 = 0;
        if(n <=1 ) return n;
        for(int i=2; i<=n; i++){
            int temp = prev1+prev2;
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
        
        
    }
    
    private int solve(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] == -1){
            dp[n] =  solve(n-1, dp) + solve(n-2, dp);
            return dp[n];
        }
        else return dp[n];
    }
    
    
}