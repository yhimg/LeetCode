class Solution {
    public int findMin(int[] arr) {
        return arr[findPivot(arr)];
    }
    
    private int findPivot(int[] arr){
        int low = 0, high = arr.length-1;
        if(low == high) return low;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid < arr.length-1 && arr[mid+1] < arr[mid]){
                return mid+1;
            }
            if(mid > 0 && arr[mid-1] > arr[mid]){
                return mid;
            }
            if(arr[low] < arr[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return 0;
    }
}