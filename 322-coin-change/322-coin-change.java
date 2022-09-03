class Solution {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        /*int[][] dp = new int[n][amount+1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int count = solve(n-1, coins, amount, dp);
        if(count >= (int)Math.pow(10,9)) return -1;
        return count;*/
        
        
        int[][] dp = new int[n][target+1];
        for(int T = 0; T <= target; T++){
            if(T % coins[0] == 0) dp[0][T] = T/coins[0];
            else dp[0][T] = (int)Math.pow(10,9);
        }
        
        
        for(int i = 1; i<n; i++){
            for(int T = 0; T<=target; T++){
                int notTake = dp[i-1][T];
                int take = (int)Math.pow(10,9);
                if(coins[i] <= T){
                    take = 1 + dp[i][T-coins[i]];
                }
                dp[i][T] = Math.min(take, notTake);
            }
        }
        return dp[n-1][target] < (int)Math.pow(10,9) ? dp[n-1][target] : -1;
    }
    
    private int solve(int index, int[] coins, int total, int[][] dp){
        
        if(index == 0){
            if(total % coins[index] == 0) return total / coins[index];
            return (int)Math.pow(10,9);
        }
        
        if(dp[index][total] != -1) return dp[index][total];
        int notTake = solve(index-1, coins, total, dp);
        int take = (int)Math.pow(10,9);
        if(coins[index] <= total){
            take = 1 + solve(index, coins, total-coins[index], dp);
        }
        
        return dp[index][total] = Math.min(take, notTake);
    }
}