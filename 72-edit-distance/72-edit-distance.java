class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i<=n; i++)
            Arrays.fill(dp[i], -1);
        return solve(n, m, s1, s2, dp);
    }
    
    private int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i == 0) return j;
        if(i == 0 || j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s2.charAt(j-1) == s1.charAt(i-1)){
            return dp[i][j] = solve(i-1, j-1, s1, s2, dp);
        } else{
            return dp[i][j] = 1+ Math.min(Math.min(solve(i, j-1, s1, s2, dp),  solve(i-1, j, s1, s2, dp)), solve(i-1, j-1, s1, s2, dp)) ;
        }
    }
}