class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);
        for(int i = first; i<=last && i >=0; i++){
            result.add(i);
        }
        return result;
        
    }
    
    public int firstOccurence(int[] arr, int target){
        int low = 0; 
        int high = arr.length-1;
        int first = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid-1;
            } else if(arr[mid] > target){
                high = mid-1;
            } else
                low = mid+1;
        }
        return first;
    }
    
    public int lastOccurence(int[] arr, int target){
        int low = 0; 
        int high = arr.length-1;
        int last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid+1;
            } else if(arr[mid] > target){
                high = mid-1;
            } else
                low = mid+1;
        }
        return last;
    }
}