class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        solve(candidates, 0, result, target, new ArrayList());
        return result;
    }
    
    private void solve(int[] candiidates, int index, List<List<Integer>> result, int target, List<Integer> mid){
        if(target < 0 || index >= candiidates.length) return;
        else if(target == 0){
            result.add(new ArrayList(mid));
        }else{
            if(candiidates[index] <= target){
                mid.add(candiidates[index]);
                solve(candiidates, index, result, target-candiidates[index], mid);
                mid.remove(mid.size()-1);
            }
            solve(candiidates, index+1, result, target, mid);
        }
        
    }
    
    
    /*private void solve(int[] candiidates, int index, List<List<Integer>> result, int target, List<Integer> mid){
        if(target < 0) return;
        else if(target == 0){
            result.add(new ArrayList(mid));
        }else{
            for(int i = index; i<candiidates.length; i++){
                if(candiidates[i] <= target){
                    mid.add(candiidates[i]);
                    solve(candiidates, i, result, target-candiidates[i], mid);
                    mid.remove(mid.size()-1);
                }

            }
        }
        
    }*/
    
}