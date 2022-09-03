class Solution {

    
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int total = 0;
        for(int x : arr) total += x;
        if (target > total || (total-target) %2 !=0) return 0;
        int sum = (total-target)/2;
        return solve(n-1, arr, sum);
    }
    
    private int solve(int index, int[] arr, int target){
        if(index == 0){
            if(target == 0 && arr[0] == 0) return 2;
            if(target ==0 || arr[index] == target) return 1;
            return 0;
        }
        
        int notTake = solve(index-1, arr, target);
        int take = 0;
        if(arr[index] <= target)
            take = solve(index-1, arr, target-arr[index]);
        
        return take+notTake;
    }
}