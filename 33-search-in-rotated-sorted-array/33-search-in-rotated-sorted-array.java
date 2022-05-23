class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
               if(target >= nums[low] && target <= nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                } 
            } else {
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                } 
            }
            
        }
        return -1;
        
        
        
        
        /*int pivot = getPivot(nums);
        int low = 0, high = nums.length-1;
        if(pivot == high) return binarySearch(nums, low, high, target);
        if(target >= nums[low] && target<= nums[pivot]) high = pivot;
        else if(target<=nums[high] && target >= nums[pivot+1]) low = pivot+1;
        return binarySearch(nums, low, high, target);*/
    }
    
    /*private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
    
    
    private int getPivot(int[] nums){
        if(nums.length <= 1) return 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]) return i;
        }
        return 0;
    }*/
}