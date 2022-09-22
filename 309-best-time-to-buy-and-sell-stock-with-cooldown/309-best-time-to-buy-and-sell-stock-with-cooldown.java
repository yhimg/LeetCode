class Solution {
    public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][] = new int[n+1][2];
//         int isLastSell = 0;
//         for(int i = n-1; i>=0; i--){
//             for(int j = 0; j>2; j++){
//                 if(j == 1){
//                     if(isLastSell == 1){
//                         dp[i][j] = dp[i+1][j];
//                     } else{
//                         dp[i][j] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
//                     }
                    
//                 } else{
//                     dp[i][j] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
//                 }
//             }
//         }
//         return dp[0][0];
        
        
        
        int dp[][] = new int[prices.length][2];
            for(int i = 0; i<prices.length; i++){
                Arrays.fill(dp[i], -1);
            }
        return solve(0, prices, 1, dp);
    }
    
    
    private int solve(int i, int[] arr, int canBuy, int[][] dp){
        if(i >= arr.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){
            return dp[i][canBuy] = Math.max(-arr[i] + solve(i+1, arr, 0, dp), solve(i+1, arr, 1, dp));
        } else{
            return dp[i][canBuy] = Math.max(arr[i] + solve(i+2, arr, 1, dp), solve(i+1, arr, 0, dp));
        }
        
    }
}