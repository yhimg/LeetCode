class Solution {
    public int maxProfit(int[] prices) {
        /*int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i<n; i++)
            for(int j = 0; j < 2; j++)
                Arrays.fill(dp[i][j], -1);
        return solve(0, prices, 2, 1, dp);*/
        
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i = 0; i<=n; i++){
            for(int buy = 0; buy<2; buy++){
                dp[i][buy][0] = 0;
            }
        }
        
        for(int buy = 0; buy<2; buy++){
            for(int count = 0; count <=2; count++){
                dp[n][buy][count] = 0;
            }
        }
        
        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                for(int count = 1; count <3; count++){
                    if(buy == 1)
                        dp[i][buy][count] = Math.max(-prices[i] + dp[i+1][0][count], dp[i+1][1][count]);
                    else
                        dp[i][buy][count] = Math.max(prices[i] + dp[i+1][1][count-1], dp[i+1][0][count]);
                }
            }
        }
        return dp[0][1][2];
        
        
    }
    
    private int solve(int i, int[] arr, int count, int buy, int[][][] dp){
        
        if(count == 0) return 0;
        if(i == arr.length) return 0;
        if(dp[i][buy][count] != -1) return dp[i][buy][count];
        if(buy == 1){
            return dp[i][buy][count] = Math.max((-arr[i] + solve(i+1, arr, count, 0, dp)), solve(i+1, arr, count, 1, dp));
        } else{
            return dp[i][buy][count] = Math.max((arr[i] + solve(i+1, arr, count-1, 1, dp)), solve(i+1, arr, count, 0, dp));
        }
    }
}