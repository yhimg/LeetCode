class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        subSeq(0, candidates, target, new ArrayList(), result);
        return result;
    }

    private void subSeq(int index, int[] arr, int target, List<Integer> mid, List<List<Integer>> result){
        
        if(target == 0){
          result.add(new ArrayList(mid)); 
          return;
         }
        
       
        
        for(int i = index; i< arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            mid.add(arr[i]);
            subSeq(i+1, arr, target-arr[i], mid, result);
            mid.remove(mid.size()-1);
        }
        
        
        //subSeq(index+1, arr, target, mid, result);
    }
}