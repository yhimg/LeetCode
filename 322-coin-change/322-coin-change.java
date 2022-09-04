class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        /*int count = solve(n-1, coins, amount);
        if(count < (int) Math.pow(10, 9)) return count;
        return -1;*/
        
        int[][] dp = new int[n][amount+1];
        
        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0) dp[0][target] = target/coins[0];
            else dp[0][target] = (int) Math.pow(10, 9);   
        }
        
        for(int i = 1; i<n; i++){
            for(int target = 0; target<= amount; target++){
                int notTake = dp[i-1][target];
                int take = (int) Math.pow(10, 9);
                if(coins[i] <= target){
                    take = 1 + dp[i][target-coins[i]];
                }
                
                dp[i][target] = Math.min(take, notTake);
                
            }
        }
        
        int count = dp[n-1][amount];
        if(count < (int) Math.pow(10, 9)) return count;
        return -1;
        
        
        
    }
    
    private int solve(int index, int[] arr, int target){
        if(index == 0){
            if(target % arr[index] == 0) return target/arr[index];
            return (int) Math.pow(10, 9);
        }
        int notTake = solve(index-1, arr, target);
        int take = (int) Math.pow(10, 9);
        if(arr[index] <= target)
            take = 1 + solve(index, arr, target-arr[index]);
        
        return Math.min(take, notTake);
    }
    
    
}