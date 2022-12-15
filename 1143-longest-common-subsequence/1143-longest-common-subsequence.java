class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        int[] prev = new int[n+1];
        
        for(int i = 1; i<=m; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                } else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        
        return prev[n];
        
        
        // for(int i = 0; i<=m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(m, n, text1, text2, dp);
    }
    
    private int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i == 0 || j == 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2, dp);
        } else{
            return dp[i][j] = Math.max(solve(i-1, j, s1, s2, dp), solve(i, j-1, s1, s2, dp));
        }
    }
}