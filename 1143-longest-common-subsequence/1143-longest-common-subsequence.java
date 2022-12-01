class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        
        
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
        
        
        // int m = text1.length();
        // int n = text2.length();
        // int[][] dp = new int[m][n];
        // for(int i = 0; i<m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(m-1, n-1, text1, text2, dp);
    }
    
    private int solve(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        int len = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            len = 1 + solve(ind1-1, ind2-1, s1, s2, dp);
        } else{
            len = Math.max(solve(ind1-1, ind2, s1, s2, dp), solve(ind1, ind2-1, s1, s2, dp));
        }
        return dp[ind1][ind2] = len;
    }
}