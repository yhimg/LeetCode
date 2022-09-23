class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int aheadBuy = 0, aheadNotBuy = 0;
        int currBuy = 0, currNotBuy = 0;
        for(int i = n-1; i>=0; i--){
            currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(prices[i] + aheadBuy - fee, aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
        
        
        
        // int dp[][] = new int[prices.length][2];
        //     for(int i = 0; i<prices.length; i++){
        //         Arrays.fill(dp[i], -1);
        //     }
        // return solve(0, prices, 1, dp);
    }
    
    
    private int solve(int i, int[] arr, int canBuy, int[][] dp, int fee){
        if(i >= arr.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){
            return dp[i][canBuy] = Math.max(-arr[i] + solve(i+1, arr, 0, dp, fee), solve(i+1, arr, 1, dp, fee));
        } else{
            return dp[i][canBuy] = Math.max(arr[i] + solve(i+1, arr, 1, dp, fee) - fee, solve(i+1, arr, 0, dp, fee));
        }
        
    }
}