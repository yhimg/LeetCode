class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List data = Arrays.asList(nums);
        perm(nums, new ArrayList(), result, new ArrayList());
        return result;
    }
    
    private void perm(int[] arr, List<Integer> mid, List<List<Integer>> result, List<Integer> map){
        
        if(mid.size() == arr.length){
            
            result.add(new ArrayList(mid));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!map.contains(arr[i])){
                mid.add(arr[i]);
                map.add(arr[i]);
                perm(arr, mid, result, map);
                map.remove(map.size()-1);
                mid.remove(mid.size()-1);
            }
        }
        
    }
}