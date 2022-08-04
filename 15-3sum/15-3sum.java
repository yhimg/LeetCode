class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//nlogn
        Set<List<Integer>> result = new HashSet();
        for(int i = 0; i<nums.length; i++){//n
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
                    k--;
                } else if(sum > 0) k--;
                else j++;
                
            }
        }
        return new ArrayList(result);
    }
}