class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        solve(0, k, new ArrayList(), result, n);
        return result;
        
    }
    
    
    
    private void solve(int index, int k, List<Integer> mid, List<List<Integer>> result, int n){
        if(index > n){
            return;
        }
        if(0 == k){
            result.add(new ArrayList(mid));
            return;
        }
        if(k > 0){
            mid.add(index+1);
            solve(index+1, k-1, mid, result, n);
            mid.remove(mid.size()-1);
        }
        solve(index+1, k, mid, result, n);
        
    }
}