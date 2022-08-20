class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, dp);
    }
    
    private int solve(int row, int col, int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        if(row == 0 && col == 0) return 1;
        
        
        return dp[row][col] = solve(row-1, col, dp) + solve(row, col-1, dp);
    }
    
    
}