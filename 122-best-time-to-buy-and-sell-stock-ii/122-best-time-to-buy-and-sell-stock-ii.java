class Solution {
    public int maxProfit(int[] prices) {
        /*int dp[][] = new int[prices.length][2];
        for(int i = 0; i<prices.length; i++)
            Arrays.fill(dp[i], -1);
        return getMaxProfit(0, prices, 1, dp);*/
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for(int i = n-1; i>=0; i--){
            for(int canBuy = 0; canBuy <2; canBuy++){
                if(canBuy == 1){
                    dp[i][canBuy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                } else{
                    dp[i][canBuy] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        
        return dp[0][1];
        
        
    }
    
    private int getMaxProfit(int i, int[] arr, int canBuy, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){
            return dp[i][canBuy] = Math.max((-arr[i] + getMaxProfit(i+1, arr, 0, dp)), (getMaxProfit(i+1, arr, 1, dp)));
        } else{
            return dp[i][canBuy] = Math.max((arr[i] + getMaxProfit(i+1, arr, 1, dp)), (getMaxProfit(i+1, arr, 0, dp)));
        }
    }
}