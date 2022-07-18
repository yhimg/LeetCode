class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> mid = new ArrayList(result.get(i));
                mid.add(n);
                if(!result.contains(mid)) result.add(mid);
            }
        }
        return result;
    }
}