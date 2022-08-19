class Solution {
    public int rob(int[] nums) {
        //Map<Integer, Integer> map = new HashMap();
        //return solve(nums.length-1, nums, map);
        int len = nums.length;
        int dp[] = new int[len];
        //Arrays.fill(nums, -1);
        dp[0] = nums[0];
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i<len;i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = 0 + prev;
            int temp = Math.max(pick, notPick);
            prev2 = prev;
            prev = temp;
        }
        return prev;
        
        /*for(int i = 1; i<len; i++){
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[len-1];*/
        
    }
    
    private int solve(int index, int nums[], Map<Integer, Integer> map){
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        if(map.containsKey(index)){
            return map.get(index);
        }
        int pick = nums[index] + solve(index-2,nums, map);
        int notPick = 0 + solve(index-1, nums, map);
        map.put(index, Math.max(pick, notPick));
        return map.get(index);
    }
}