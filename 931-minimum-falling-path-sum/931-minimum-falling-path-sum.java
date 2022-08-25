class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /*int m = matrix.length; 
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++){
            min = Math.min(min, solve(0, j, matrix, m, n, dp));
        }
        return min;*/
        
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(i == 0){
                    dp[0][j] = matrix[0][j];
                }
                else{
                    int x = Integer.MAX_VALUE;
                    dp[i][j] = matrix[i][j];
                    if(j > 0 && j < n-1 ){
                        x = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j+1]), dp[i-1][j]);
                    } else if(j > 0) {
                        x = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    } else if(j < n-1){
                        x = Math.min(dp[i-1][j], dp[i-1][j+1]);
                    }
                    if(x != Integer.MAX_VALUE)
                        dp[i][j] += x;
                }
                
                if(i == m-1){
                    min = Math.min(min, dp[i][j]);
                }
            }
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