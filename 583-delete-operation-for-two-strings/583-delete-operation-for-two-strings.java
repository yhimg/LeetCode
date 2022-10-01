class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return m-dp[m][n]+n-dp[m][n];
        // int lcs = solve(m, n, s1, s2);
        // return m-lcs+n-lcs;
    }
    
    int solve(int i, int j, String s1, String s2){
        if(i == 0 || j == 0) return 0;
        int lcs = 0;
        if(s1.charAt(i-1) == s2.charAt(j-1))
          lcs = 1 + solve(i-1, j-1, s1, s2);
        else
          lcs += Math.max(solve(i-1, j, s1, s2), solve(i, j-1, s1, s2));

        return lcs;
  }
}