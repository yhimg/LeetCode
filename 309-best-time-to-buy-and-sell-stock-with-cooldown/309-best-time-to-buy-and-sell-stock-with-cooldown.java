class Solution {
    public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][] = new int[n+1][2];
        
//         for(int i = n-1; i>=0; i--){
//             for(int j = 0; j>2; j++){
//                 if(j == 1){
//                     dp[i][j] = Math.max(prices[i] + dp[i+1][0], dp[i+1][1]);
//                 } else{
//                     dp[i][j] = Math.max(-prices[i] + dp[i+1][1], dp[i+1][0]);
//                 }
//             }
//         }
//         return dp[0][0];
        int dp[][][] = new int[prices.length][2][2];
            for(int i = 0; i<prices.length; i++){
                for(int j = 0; j<2; j++){
                    Arrays.fill(dp[i][j], -1);
                }
            }
        return solve(0, prices, 1, 0, dp);
    }
    
    
    private int solve(int i, int[] arr, int canBuy, int isLastSell, int[][][] dp){
        if(i == arr.length) return 0;
        if(dp[i][canBuy][isLastSell] != -1) return dp[i][canBuy][isLastSell];
        if(canBuy == 1){
            if(isLastSell == 1){
                return dp[i][canBuy][isLastSell] = solve(i+1, arr, 1, 0, dp);
            } else{
                return dp[i][canBuy][isLastSell] = Math.max(-arr[i] + solve(i+1, arr, 0, 0, dp), solve(i+1, arr, 1, 0, dp));
            }
        } else{
            return dp[i][canBuy][isLastSell] = Math.max(arr[i] + solve(i+1, arr, 1, 1, dp), solve(i+1, arr, 0, 0, dp));
        }
        
    }
}