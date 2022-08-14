class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0; 
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid == 0) low++;
            else if(mid == arr.length-1) high--;
            
            else if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                ans=mid;
                break;
            }
            else if(arr[mid] < arr[mid-1]) high = mid-1;
            else low = mid+1;
        }
        return ans;
    }
}