class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        solve(0, candidates, result, new ArrayList(), target, 0);
        return result;
    }
    
    private void solve(int index, int[] arr, List<List<Integer>> result, List<Integer> mid, int sum, int currSum){
        if(currSum == sum){
            result.add(new ArrayList(mid));
            return;
        }
        
        
        for(int i = index; i<arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            
            if(currSum +arr[i] > sum){
                break;
            }
            mid.add(arr[i]);
            solve(i+1, arr, result, mid, sum, currSum+arr[i]);
            mid.remove(mid.size()-1);
        }
        
    }
}