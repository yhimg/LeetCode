class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        solve(1, k, new ArrayList(), result, n);
        return result;
        
    }
    
    
    
    private void solve(int index, int k, List<Integer> mid, List<List<Integer>> result, int n){
        
        if(mid.size() == k){
            result.add(new ArrayList(mid));
            return;
        }
        
        for(int i = index; i<=n; i++){
            mid.add(i);
            solve(i+1, k, mid, result, n);
            mid.remove(mid.size()-1);
        }
        
        
    }
}