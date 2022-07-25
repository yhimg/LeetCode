class Solution {
    public int[] numberOfPairs(int[] nums) {
        /*Map<Integer, Integer> map = new HashMap();
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
        
        return ans;*/
        
        int count[] = new int[101];
        for(int i: nums) count[i]++;
        int pair = 0, leftOver = 0;
        for(int i: count){
            pair += i/2;
            leftOver += i%2;
        }
        
        return new int[]{pair, leftOver};
        
    }
}