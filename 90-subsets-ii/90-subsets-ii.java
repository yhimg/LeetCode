class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        /*result.add(new ArrayList());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> mid = new ArrayList(result.get(i));
                mid.add(n);
                if(!result.contains(mid)) result.add(mid);
            }
        }*/
        subSeq(0, nums, result, new ArrayList());
        return result;
    }
    
    private void subSeq(int idx, int[] arr, List<List<Integer>> result, List<Integer> mid){
        
        mid.stream().forEach(System.out::print);
        System.out.println();
        result.add(new ArrayList(mid));
        
        for(int i=idx; i< arr.length; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            mid.add(arr[i]);
            subSeq(i+1, arr, result, mid);
            mid.remove(mid.size()-1);
        }
        
        //subSeq(idx+1, arr, result, mid);
    }
}