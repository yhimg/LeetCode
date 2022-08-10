class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList();
        solve(1, n, k, result, new ArrayList());
        return result;
        
    }
    
    private void solve(int index, int n, int k, List<List<Integer>> result, List<Integer> mid){
        if(mid.size() == k){
            result.add(new ArrayList(mid));
            return;
        }
        for(int i = index; i<=n - (k - mid.size()) +1 ; i++){
            mid.add(i);
            solve(i+1, n, k, result, mid);
            mid.remove(mid.size()-1);
        }
    }
    
    
}