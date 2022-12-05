class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            System.out.println(key);
            if(buckets[map.get(key)] == null)
                buckets[map.get(key)] = new ArrayList();
            buckets[map.get(key)].add(key);
        }
        
        int i = buckets.length - 1;
        int[] ans = new int[k];
        int count = 0;
        while(count < k){
            if(buckets[i] != null){
                for(int x : buckets[i]){
                    if(count == k) break;
                    ans[count] = x;
                    count++;
                }
            }
            i--;
        }
        return ans;
        
        
//         List<Integer> keys = new ArrayList(map.keySet());
        
//         Collections.sort(keys, (a, b) -> map.get(b)-map.get(a));
//         int[] ans = new int[k];
//         for(int i =0; i<k; i++){
//             ans[i] = keys.get(i);
//         }
//         return ans;
        
        
    }
}