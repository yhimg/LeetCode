class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//nlogn
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i<nums.length; i++){//O(n)
            if(nums[i] > 0) break;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1, k = nums.length -1;
            while(j<k){//O(n)
                int sum = nums[j] + nums[k] + nums[i];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(nums[j] == nums[j-1] && j < k) j++;
                } else if(sum > 0) k--;
                else j++;   
            }
        }
        return result;
    }
}