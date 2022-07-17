class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        subSeq(0, candidates, target, new ArrayList(), result);
        return result;
    }
    
    private void subSeq(int index, int[] arr, int target, List<Integer> mid, List<List<Integer>> result){
        
        if(target == 0){
            mid.stream().forEach(System.out::print);
            System.out.println();
            result.add(new ArrayList(mid));
            return;
         }
        
        if(index >= arr.length || target < 0) return;
        
        mid.add(arr[index]);
        subSeq(index, arr, target-arr[index], mid, result);
            
        mid.remove(mid.size()-1);
        subSeq(index+1, arr, target, mid, result);        
    }
}