class Solution {
    public int longestPalindromeSubseq(String s) {
        /*int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for(int i = 0; i<=len; i++)
            Arrays.fill(dp[i], -1);
        int ans =  solve(1, len, s, len, dp);
        
        for(int i = 0; i<=len; i++){
            for(int j = 0; j<=len; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return ans;*/
        String s2 = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int [][] dp = new int[len+1][len+1];
        
        int ans = 0;
        for(int i = 1; i<=len; i++){
            //int curr[] = new int[len+1];
            for(int j = 1; j<=len; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                } else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
        
        
    }
    
    private int solve(int i, int j, String s1, String s2, int[][] dp){
        if(j <=0 || i <= 0)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + solve(i+1, j-1, s1, s2, dp);
        
        return dp[i][j] = Math.max(solve(i+1, j, s1, s2, dp), solve(i, j-1, s1, s2, dp));
    }
}