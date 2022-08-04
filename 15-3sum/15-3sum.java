class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//nlogn
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i<nums.length; i++){//n
            if(nums[i] > 0) break;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1, k = nums.length -1;
            while(j<k){//logn
                List<Integer> mid = new ArrayList();
                int sum = nums[j] + nums[k] + nums[i];
                if( sum == 0){
                    mid.add(nums[i]);
                    mid.add(nums[j]);
                    mid.add(nums[k]);
                    result.add(mid);
                    j++;
                    while(nums[j] == nums[j-1] && j < k) j++;
                } else if(sum > 0) k--;
                else j++;
                
            }
        }
        return result;
    }
}