class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2*k+1];
        for(int i = n-1; i>=0; i--){
            for(int tran = 2*k-1; tran >=0; tran--){
                if(tran %2 == 0){
                    dp[i][tran] = Math.max(-prices[i]+dp[i+1][tran+1], dp[i+1][tran]);
                } else{
                    dp[i][tran] = Math.max(prices[i]+dp[i+1][tran+1], dp[i+1][tran]);
                }
            }
        }
        return dp[0][0];
    }
}