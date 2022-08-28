class Solution {
    
    private boolean helper(int index, int sum, int target, int[] arr){
        if(sum == target) return true;
        
        if(index < 0) return false;
        
        boolean take = false;
        if(sum+arr[index] <= target){
            take = helper(index - 1, sum+arr[index], target, arr);
        }
        boolean notTake = helper(index-1, sum, target, arr);
        
        return take || notTake;
    }
    
    
    
    
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        if(sum %2 != 0 ) return false;
        //return helper(n-1, 0, sum, nums);
        int k = sum/2;
        
        boolean dp[][] = new boolean[n][k+1];
        
        boolean prev[] = new boolean[k+1];
        prev[0] = true;
        prev[k] = k == arr[0];
        
        for(int index = 1; index < n; index++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target = 1; target <= k; target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[index] <= target)
                    take = prev[target-arr[index]];
                curr[target] = take || notTake;
            }
            prev = curr;
        }
        
        return prev[k];
        
        /*for(int ind = 0; ind < n; ind++)
            dp[ind][0] = true;
        
        dp[0][k] = k == arr[0];
        
        for(int ind = 1; ind < n; ind++){
            for(int target = 0; target <= k; target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind] <= target)
                    take = dp[ind-1][target-arr[ind]];
                
                dp[ind][target] = take || notTake;
            }
        }
        return dp[n-1][k];*/
    
        
    }
    
    private boolean solve(int index, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(index == arr.length) return false;
        
        if(dp[index][target] != -1) return dp[index][target] == 1 ? true : false;
        boolean take = false;
        if(arr[index] <= target) take = solve(index+1, target-arr[index], arr, dp);
        boolean notTake = solve(index+1, target, arr, dp);
        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}