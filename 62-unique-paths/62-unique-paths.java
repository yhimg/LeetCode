class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        /*for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, dp);*/
        
        dp[0][0] = 1;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                } else {
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                    
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    private int solve(int row, int col, int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        if(row == 0 && col == 0) return 1;
        
        
        return dp[row][col] = solve(row-1, col, dp) + solve(row, col-1, dp);
    }
    
    
}