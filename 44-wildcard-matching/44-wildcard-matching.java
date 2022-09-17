class Solution {
    public boolean isMatch(String S2, String S1) {
        /*int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
          Arrays.fill(row, -1);
        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp) == 1 ? true : false;*/
        
        
        int n = S1.length();
        int m = S2.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
          dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
          dp[i][0] = isAllStars1(S1, i);
        }

        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {

            if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
              dp[i][j] = dp[i - 1][j - 1];

            else {
              if (S1.charAt(i - 1) == '*')
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

              else dp[i][j] = false;
            }
          }
        }

        return dp[n][m];
    }
    
    boolean isAllStars1(String S1, int i) {

        // S1 is taken in 1-based indexing
        for (int j = 1; j <= i; j++) {
          if (S1.charAt(j - 1) != '*')
            return false;
        }
        return true;
  }
    
    private int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {

    //Base Conditions
    if (i < 0 && j < 0)
      return 1;
    if (i < 0 && j >= 0)
      return 0;
    if (j < 0 && i >= 0)
      return isAllStars(S1, i) ? 1 : 0;

    if (dp[i][j] != -1) return dp[i][j];

    if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
      return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

    else {
      if (S1.charAt(i) == '*')
        return dp[i][j] = (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
      else return dp[i][j] = 0;
    }
  }
    
    private boolean isAllStars(String S1, int i){
        for (int j = 0; j <= i; j++) {
      if (S1.charAt(j) != '*')
        return false;
    }
    return true;
    }
}