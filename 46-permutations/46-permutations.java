class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> map = new ArrayList();
        List<Integer> mid = new ArrayList();
        
        for(int i=0; i<nums.length; i++){
            map.add(nums[i]);
            
        }
        
        permu(0, nums, result);
        
        
        //perm(nums, new ArrayList(), result, new ArrayList());
        
        
        
        
        return result;
    }
    
    private void permu(int index, int[] arr, List<List<Integer>> result){

        if(index == arr.length){
            List<Integer> mid = new ArrayList();
            for(int x: arr){
                mid.add(x);
            }
            result.add(new ArrayList(mid));
            return;
        }
            
        for(int i = index; i< arr.length; i++){
            
            swap(i, index, arr);
            permu(index+1, arr, result);
            swap(i, index, arr);
            //mid.add(Arrays.asList(arr));
            
        }
    }
    
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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