class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Map<Integer, Integer> map = new HashMap();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        List<Integer> ans = new ArrayList();
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                ans.add(Math.abs(nums[i]));
            }
            nums[index] *= -1; 
        }
        
        
        // for(int key : map.keySet()){
        //     if(map.get(key) == 2)
        //         ans.add(key);
        // }
        return ans;
    }
}