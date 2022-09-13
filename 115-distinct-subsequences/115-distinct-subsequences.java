class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        /*int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<= n; i++)
            Arrays.fill(dp[i], -1);
        return solve(n, m, s, t, dp);*/
        
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<= n; i++)
            dp[i][0] = 1;
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(t.charAt(j-1) == s.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
        
    }
    
    private int solve(int i, int j, String s, String t, int[][] dp){
        if(j == 0) return 1;
        if(i == 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        if(t.charAt(j-1) == s.charAt(i-1)){
            return dp[i][j] = solve(i-1, j-1, s, t, dp) + solve(i-1, j, s, t, dp);
        }
        else{
            return dp[i][j] = solve(i-1, j, s, t, dp);
        }
        
    }
}