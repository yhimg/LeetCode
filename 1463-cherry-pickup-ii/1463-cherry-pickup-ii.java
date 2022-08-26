class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for(int i = 0;i <r; i++){
            for(int j = 0; j<c; j++){
                for(int k = 0; k<c; k++){
                    dp[i][j][k] = -1;
                }
                
            }
        }
        return solve(0, 0, c-1, grid, r, c, dp);
	}
    
    private int solve(int i, int j1, int j2, int[][] arr, int m, int n, int[][][] dp){
        if(i < 0 || j1 == n || j2 == n || j1 <0 || j2 <0){
            return Integer.MIN_VALUE;
        }
        if(j1 == j2) return arr[i][j1];
        
        if(i == m-1){
            return arr[i][j1] + arr[i][j2];
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE;
        for(int x = -1; x<2; x++){
            for(int y = -1; y<2; y++){
                max = Math.max(max, solve(i+1, j1+x, j2+y, arr, m, n, dp));
            }
        }
        
        return dp[i][j1][j2] = arr[i][j1] + arr[i][j2] + max;
        
        
    }
}