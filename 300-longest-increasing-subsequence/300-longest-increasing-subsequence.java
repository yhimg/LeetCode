class Solution {
    public int lengthOfLIS(int[] arr) {
        // int n = nums.length;
        // int dp[][] = new int[n][n+1];
        // for(int i = 0; i<n; i++)
        //     Arrays.fill(dp[i], -1);
        // return solve(0, -1, nums, dp);
        
//         int n = arr.length;
//         int dp[][] = new int[n+1][n+1];
//         for(int i = n-1; i>=0; i--){
//             for(int j = i-1; j>=-1; j--){
//                 int len = dp[i+1][j+1];
//                 if(j == -1 || arr[i] > arr[j])
//                     len = Math.max(len, 1 + dp[i+1][i+1]);
//                 dp[i][j+1] = len;
//             }
//         }
        
//         return dp[0][0];
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i<=n-1; i++){
            for(int prev_i = 0; prev_i<i; prev_i++){
                if(arr[prev_i] < arr[i]){
                    dp[i] = Math.max(1+dp[prev_i], dp[i]);
                }
            }
        }
        
        Arrays.sort(dp);
        return dp[n-1];
        
        
        
        
    }
    
    private int solve(int i, int prev_i, int[] arr, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][prev_i+1] != -1) return dp[i][prev_i];
        int take = 0;
        if(prev_i == -1 || arr[i] > arr[prev_i])
            take = 1 + solve(i+1, i, arr, dp);
        int notTake = solve(i+1, prev_i, arr, dp);
        
        return dp[i][prev_i+1] = Math.max(take, notTake);
    }
}