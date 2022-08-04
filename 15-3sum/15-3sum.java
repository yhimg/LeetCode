class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//nlogn
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i<nums.length; i++){//n
            if(nums[i] > 0) break;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1, k = nums.length -1;
            while(j<k){//logn
                if(j > i+1 && nums[j-1] == nums[j] ){
                    j++;
                    continue;
                }
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
        return result;
        
        
        /*int i=0;
        Arrays.sort(nums);//nlogn
        List<List<Integer>> result = new HashSet();
        
        while(i<nums.length-1){
            int j = i+1;
            int sum = nums[i]+nums[j];
            int low = j+1;
            int high = nums.length -1;
            List<Integer> midList = new ArrayList();
            while(low <= high){
                int mid = low + (high-low)/2;
                if(sum+nums[mid] == 0){
                    midList.add(nums[i]);
                    midList.add(nums[j]);
                    midList.add(nums[mid]);
                    result.add(midList);
                    low++;
                    high--;
                    result.add(midList);
                } else if(sum + nums[mid] > 0){
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            
            i++;
            j++;
        }
        return result;*/
    }
}