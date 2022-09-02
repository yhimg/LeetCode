class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int count = solve(n-1, coins, amount, dp);
        if(count >= (int)Math.pow(10,9)) return -1;
        return count;
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