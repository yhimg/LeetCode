class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        int i = 0;
        while(i<=maxPos){
            maxPos = Math.max(maxPos, i + nums[i]);
            if(maxPos >= nums.length-1) return true;
            i++;
        }
        return false;
        
        
        
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return solve(0, nums, dp);
    }


    private boolean solve(int ind, int[] arr, int[] dp){
        if(ind == arr.length-1) return true;
        if(ind >= arr.length) return false;
        if(dp[ind] != -1){
            return dp[ind] == 1 ? true : false;
        }
        boolean canGo = false;
        for(int i = 1; i<=arr[ind]; i++){
            canGo = canGo || solve(i+ind, arr, dp);
        }
        
        if(canGo){
            dp[ind] = 1;
        } else{
            dp[ind] = 0;
        }
        return canGo;
    }
}