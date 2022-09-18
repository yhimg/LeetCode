class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0; i<prices.length; i++)
            Arrays.fill(dp[i], -1);
        return getMaxProfit(0, prices, 1, dp);
        
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