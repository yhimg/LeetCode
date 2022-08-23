class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        
        int[][] dp = new int[m][triangle.get(m-1).size()];
        for(int i = 0; i< m;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, 0, triangle, m, dp);
    }
    
    private int solve(int i, int j, List<List<Integer>> triangle, int m, int[][] dp){
        if(i == m-1 && triangle.get(i).size()-1 <= i)
            return triangle.get(i).get(j);
        
        if(i == m || j > i) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j) + Math.min(solve(i+1, j, triangle, m, dp), solve(i+1, j+1, triangle, m, dp));
    }
}