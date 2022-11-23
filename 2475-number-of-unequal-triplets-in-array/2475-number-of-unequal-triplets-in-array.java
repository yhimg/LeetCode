class Solution {
    public int unequalTriplets(int[] nums) {
        return solve(0, nums, new ArrayList());
    }
    
    public static int solve(int i, int[] arr, List<Integer> mid){
    if(mid.size() == 3){
      return 1;
    }
    if(i >= arr.length){
      return 0;
    }
    int len = 0;
    if(!mid.contains(arr[i])){
      mid.add(arr[i]);
      len += solve(i+1, arr, mid);
      mid.remove(mid.size()-1);
      len += solve(i+1, arr, mid);
    } else{
      len += solve(i+1, arr, mid);
    }
    return len;

  }
}