class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        //Arrays.sort(nums);
        permu(0, nums, result);
        return result;
    }
    
    private void permu(int index, int[] arr, List<List<Integer>> result){
        if(index >= arr.length){
            List<Integer> mid = new ArrayList();
            for(int x : arr){
                mid.add(x);
            }
            result.add(mid);
            return;
        }
        Set<Integer> used = new HashSet();
        
        for(int i=index; i <arr.length; i++){
            if(used.add(arr[i])){
                swap(i, index, arr);
                permu(index+1, arr, result);
                swap(i, index, arr);
                
            }
            
            
        }
    }
    
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    
    
    
}