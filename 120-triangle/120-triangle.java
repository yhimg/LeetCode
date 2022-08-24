class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        /*int m = triangle.size();
        
        int[][] dp = new int[m][triangle.get(m-1).size()];
        for(int i = 0; i< m;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, 0, triangle, m, dp);*/
        
        /*int m = triangle.size();
        
        int[][] dp = new int[m][triangle.get(m-1).size()];
        
        for(int i = 0; i<triangle.get(m-1).size(); i++){
            dp[m-1][i] = triangle.get(m-1).get(i);
        }
        
        for(int i = m-1; i>=0; i--){
            for(int j = triangle.get(i).size()-1; j>= 0 ; j--){
                if(i == m-1) dp[m-1][j] = triangle.get(m-1).get(j);
                else{
                 dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];*/
        
        int m = triangle.size();
        
        int[] prev = new int[m];
        
        for(int i = m-1; i>=0; i--){
            int[] curr = new int[triangle.get(i).size()];
            for(int j = triangle.get(i).size()-1; j>= 0 ; j--){
                if(i == m-1){
                    curr[j] = triangle.get(i).get(j);
                } 
                else{
                 curr[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j+1]);
                }
            }
            System.out.println(curr[0] + ", "+ curr[curr.length-1]);
            prev = curr;
        }
        return prev[0];
        
        
    }
    
    /*private int solve(int i, int j, List<List<Integer>> triangle, int m, int[][] dp){
        if(i == m-1 && triangle.get(i).size()-1 <= i)
            return triangle.get(i).get(j);
        
        if(i == m || j > i) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j) + Math.min(solve(i+1, j, triangle, m, dp), solve(i+1, j+1, triangle, m, dp));
    }*/
}