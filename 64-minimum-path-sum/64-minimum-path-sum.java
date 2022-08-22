class Solution {
    public int minPathSum(int[][] grid) {
        /*int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int i = 0; i< m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, grid, dp);*/
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //dp[0][0] = grid[0][0];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int min = Integer.MAX_VALUE;
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                dp[i][j] = grid[i][j];
                if(i > 0){
                    min = Math.min(min, dp[i-1][j]);
                }
                if(j > 0){
                    min = Math.min(min, dp[i][j-1]);
                }
                if(min != Integer.MAX_VALUE)
                    dp[i][j] += min;
            }
        }
        return dp[m-1][n-1];
        
    }
    
    private int solve(int row, int col, int[][] grid, int[][] dp){
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        
        if(dp[row][col] != -1) return dp[row][col];
        if(row == 0 && col == 0) return dp[row][col] = grid[row][col];

        return dp[row][col] = grid[row][col] + Math.min(solve(row-1, col, grid, dp), solve(row, col-1, grid, dp));
    }
}