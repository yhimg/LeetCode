class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        solve(1, n, k, result, new ArrayList(), 0);
        return result;
    }
    
    private void solve(int start, int sum, int k, List<List<Integer>> result, List<Integer> mid, int currSum){
        if(currSum == sum && mid.size() == k){
            result.add(new ArrayList(mid));
            return;
        }
        for(int i = start; i<=9; i++){
            if(currSum <= sum && mid.size() < k){
                currSum += i;
                mid.add(i);
                solve(i+1, sum, k, result, mid, currSum);
                currSum -= i;
                mid.remove(mid.size()-1);
            }
        }
    }
}