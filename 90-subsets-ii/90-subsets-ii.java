class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length==0) return result;
        Arrays.sort(nums);
        subSeq(0, nums, new ArrayList(), result);
        return result;
    }
    
    
    private void subSeq(int index, int[] arr, List<Integer> mid, List<List<Integer>> result){
        
        result.add(new ArrayList(mid));
        
        for(int i = index; i<arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            mid.add(arr[i]);
            subSeq(i+1, arr, mid, result);
            mid.remove(mid.size()-1);
        }
    }
}