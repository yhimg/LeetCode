class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i = 1; i<len-1; i++){
            int pick = nums[i];
            if(i>1) pick += prev2;
            int notPick = prev1;
            int temp = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = temp;
        }
        int prev3 = nums[1];
        int prev4 = 0;
        for(int i = 2; i<len; i++){
            int pick = nums[i] + prev4;
            int notPick = prev3;
            int temp = Math.max(pick, notPick);
            prev4 = prev3;
            prev3 = temp;
        }
        return Math.max(prev1, prev3);
    }
}