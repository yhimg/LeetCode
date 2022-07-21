class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int ans = 0;
        int size = height.length;
        left[0] = height[0];
        for(int i=1; i< size; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[size-1] = height[size-1];
        for(int i = size-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        for(int i=1; i<size-1; i++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        
        return ans;
        
        
    }
}