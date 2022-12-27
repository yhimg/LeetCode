class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = rocks.length;
        int count = 0;
        
        int[] left = new int[len];
        for(int i = 0; i<len; i++){
            left[i] = capacity[i] - rocks[i];
        }
        
    
        
        Arrays.sort(left);
        
        for(int i = 0; i<len; i++){
            if(left[i]>0){
                if(left[i] <= additionalRocks){
                    additionalRocks -= left[i];
                    left[i] = 0;
                }
                
            }
            if(left[i] == 0) count++;
        }
        return count;
    }
}