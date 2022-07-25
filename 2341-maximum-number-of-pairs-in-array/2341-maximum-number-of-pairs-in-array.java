class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int ans[] = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                nums[map.get(nums[i])] = -1;
                map.remove(nums[i]);
                nums[i] = -1;
                ans[0]++;
                ans[1]--;
            } else{
                map.put(nums[i], i);
                ans[1]++;
            }
        }
        
        return ans;
    }
}