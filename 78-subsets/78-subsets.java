class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        subSeq(0, nums, result, new ArrayList());
        return result;
    }
    
    private void subSeq(int index, int[] arr, List<List<Integer>> result, List<Integer> mid){
        
        if(index > arr.length) return;
        result.add(new ArrayList(mid));
        
        for(int i=index; i<arr.length; i++){
            mid.add(arr[i]);
            subSeq(i+1, arr, result, mid);
            mid.remove(mid.size()-1);
        }
        
        
        
        /*if(index == arr.length){
            result.add(new ArrayList(mid));
            return;
        }
        
        mid.add(arr[index]);
        subSeq(index+1, arr, result, mid);
        mid.remove(mid.size()-1);
        subSeq(index+1, arr, result, mid);*/
        
    }
}