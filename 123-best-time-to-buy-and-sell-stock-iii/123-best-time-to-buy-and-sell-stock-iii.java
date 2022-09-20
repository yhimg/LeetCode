class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i<n; i++)
            for(int j = 0; j < 2; j++)
                Arrays.fill(dp[i][j], -1);
        return solve(0, prices, 0, 1, dp);
        
    }
    
    private int solve(int i, int[] arr, int count, int buy, int[][][] dp){
        
        if(count == 2) return 0;
        if(i == arr.length) return 0;
        if(dp[i][buy][count] != -1) return dp[i][buy][count];
        if(buy == 1){
            return dp[i][buy][count] = Math.max((-arr[i] + solve(i+1, arr, count, 0, dp)), solve(i+1, arr, count, 1, dp));
        } else{
            return dp[i][buy][count] = Math.max((arr[i] + solve(i+1, arr, count+1, 1, dp)), solve(i+1, arr, count, 0, dp));
        }
    }
}