class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        return solve(nums.length-1, nums, map);
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