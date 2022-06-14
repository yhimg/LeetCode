class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = findFirst(nums, target);
        arr[1] = findLast(nums, target);
        return arr;
    }
    
    private int findFirst(int[] arr, int k){
        int low = 0, high = arr.length-1;
        int first = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                first = mid;
                high = mid-1;
            } else if(arr[mid] > k){
                high = mid -1;
            } else{
                low = mid+1;
            }
        }
        return first;
    }
    
    private int findLast(int[] arr, int k){
        int low = 0, high = arr.length-1;
        int last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                last = mid;
                low = mid + 1;
            } else if(arr[mid] > k){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return last;
    }
}