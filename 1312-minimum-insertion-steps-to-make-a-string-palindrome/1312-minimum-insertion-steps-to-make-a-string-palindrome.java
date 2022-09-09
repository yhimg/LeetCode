class Solution {
    public int minInsertions(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        
        int dp[][] = new int[n+1][n+1];
        
        int len = 0;
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    len = Math.max(len, dp[i][j]);
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return n-len;
        
    }
}