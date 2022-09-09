class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for(int i = 0; i<=len; i++)
            Arrays.fill(dp[i], -1);
        return solve(1, len, s, len, dp);
    }
    
    private int solve(int i, int j, String s, int n, int[][] dp){
        if(j <=0 || i>n)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i-1) == s.charAt(j-1))
            return dp[i][j] = 1 + solve(i+1, j-1, s, n, dp);
        
        return dp[i][j] = Math.max(solve(i+1, j, s, n, dp), solve(i, j-1, s, n, dp));
    }
}