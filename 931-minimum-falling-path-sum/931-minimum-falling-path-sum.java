class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++){
            min = Math.min(min, solve(0, j, matrix, m, n, dp));
        }
        return min;
    }
    
    
    private int solve(int i, int j, int[][] arr, int m, int n, int[][] dp){
        if(i == m || j == n || j < 0) return Integer.MAX_VALUE;
        
        if(i == m-1) return arr[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = arr[i][j] + Math.min(Math.min(solve(i+1, j-1, arr, m, n, dp), solve(i+1, j, arr, m, n, dp)), solve(i+1, j+1, arr, m, n, dp));
    }
}