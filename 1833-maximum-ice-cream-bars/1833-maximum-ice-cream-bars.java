class Solution {
    int count = 0;
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, costs, coins, dp);
    
        
    }
    
    private int solve(int i, int[] arr, int target, int[] dp){
        if(i == arr.length-1){
            if(arr[i] <= target){
                return 1;
            }
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        if(arr[i] <= target){
            return dp[i] = 1 + solve(i+1, arr, target-arr[i], dp);
        }
        return 0;
    }
    
}