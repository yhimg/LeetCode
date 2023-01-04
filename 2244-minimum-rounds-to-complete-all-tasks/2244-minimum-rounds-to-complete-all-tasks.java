class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap();
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int count = 0;
        for(int freq : map.values()){
            if(freq == 1) return -1;
            count += (freq+2)/3;
        }
        return count;
    }
}