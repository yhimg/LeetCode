class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                int pick = 0;
                int notPick = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    pick = 1 + dp[i-1][j-1];
                else
                    notPick = Math.max(dp[i-1][j], dp[i][j-1]);
                
                dp[i][j] = pick + notPick;
            }
        }
        return dp[m][n];
        //return solve(s1.length(), s2.length(), s1, s2);
        
    }
    
    int solve(int i, int j, String str1, String str2){
        if(i == 0 || j == 0){
          return 0;
        }
        int pick = 0;
        int notPick = 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)){
          pick = 1 + solve(i-1, j-1, str1, str2);
        } else{
          notPick = Math.max(solve(i-1, j, str1, str2), solve(i, j-1, str1, str2));
        }
        return pick + notPick;
  }
}