class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        solve(0, candidates, result, new ArrayList(), target);
        return result;
    }
    
    
    private void solve(int index, int[] arr, List<List<Integer>> result, List<Integer> mid, int target){
        
        if(index >= arr.length){
            return;
        }
        
        if(target == 0){
            result.add(new ArrayList(mid));
            return;
        }
        
        if(target>0){
            mid.add(arr[index]);
            target -= arr[index];
            solve(index, arr, result, mid, target);
            target += arr[index];
            mid.remove(mid.size() -1);
        }
        
        solve(index+1, arr, result, mid, target);
    }
}