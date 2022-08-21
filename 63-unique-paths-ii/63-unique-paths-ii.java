class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];
        for(int i = 0; i<row; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(row-1, col-1, obstacleGrid, dp);*/
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(obstacleGrid[i][j] != 1){
                   if(i == 0 && j == 0) dp[i][j] = 1;
                    else{
                        if(i > 0) dp[i][j] = dp[i-1][j];
                        if(j > 0) dp[i][j] += dp[i][j-1];
                    } 
                }
                //System.out.println(dp[i][j]);
            }
        }
        return dp[row-1][col-1];
        
    }
    
    
    private int solve(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0 && grid[row][col] != 1) return 1;
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int count = 0;
        if(grid[row][col] != 1){
            int up = solve(row-1, col, grid, dp);
            int left = solve(row, col-1, grid, dp);
            count = up+left;
        }
        return dp[row][col] = count;
    }
}